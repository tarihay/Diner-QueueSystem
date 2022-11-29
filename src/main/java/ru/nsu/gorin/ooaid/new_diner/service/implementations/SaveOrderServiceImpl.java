package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.exceptions.NoSuchProductFoundException;
import ru.nsu.gorin.ooaid.new_diner.model.OrderDTO;
import ru.nsu.gorin.ooaid.new_diner.model.OrderItemDTO;
import ru.nsu.gorin.ooaid.new_diner.model.OrderStatus;
import ru.nsu.gorin.ooaid.new_diner.repository.OrderItemRepository;
import ru.nsu.gorin.ooaid.new_diner.repository.OrderRepository;
import ru.nsu.gorin.ooaid.new_diner.repository.ProductRepository;
import ru.nsu.gorin.ooaid.new_diner.repository.UserRepository;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderItemEntity;
import ru.nsu.gorin.ooaid.new_diner.service.SaveOrderService;
import ru.nsu.gorin.ooaid.new_diner.service.OrderQueueService;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class SaveOrderServiceImpl implements SaveOrderService {
    private final OrderQueueService orderQueueService;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SaveOrderServiceImpl(OrderQueueService orderQueueService, OrderItemRepository orderItemRepository, OrderRepository orderRepository,
                                UserRepository userRepository, ProductRepository productRepository) {
        this.orderQueueService = orderQueueService;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public long saveOrder(OrderDTO orderDTO) throws NoSuchProductFoundException {
        String nickname = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Set<OrderItemEntity> orderItems = new HashSet<>();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(userRepository.findByNickname(nickname));
        orderEntity.setStatus(OrderStatus.IN_PROGRESS);
        orderEntity = orderRepository.save(orderEntity);

        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            OrderItemEntity orderItemEntity = mapOrderItemDTOToEntity(orderItemDTO);
            orderItemEntity.setOrder(orderEntity);

            orderItemEntity = orderItemRepository.save(orderItemEntity);

            orderItems.add(orderItemEntity);
        }


        orderEntity.setOrderItems(orderItems);
        orderEntity = orderRepository.save(orderEntity);

        orderQueueService.addToQueue(orderEntity);

        return orderEntity.getId();
    }

    private OrderItemEntity mapOrderItemDTOToEntity(OrderItemDTO orderItemDTO) throws NoSuchProductFoundException {
        OrderItemEntity orderItem = new OrderItemEntity();

        try {
            orderItem.setProduct(productRepository.findById(orderItemDTO.getProductId()).get());
        } catch (NullPointerException ex) {
            log.error("No such product found");
            throw new NoSuchProductFoundException("No such product found");
        }
        orderItem.setAmount(orderItemDTO.getAmount());

        return orderItem;
    }
}
