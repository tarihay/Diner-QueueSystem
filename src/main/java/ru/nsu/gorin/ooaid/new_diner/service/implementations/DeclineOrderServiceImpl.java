package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.model.OrderStatus;
import ru.nsu.gorin.ooaid.new_diner.repository.OrderRepository;
import ru.nsu.gorin.ooaid.new_diner.service.DeclineOrderService;
import ru.nsu.gorin.ooaid.new_diner.service.OrderQueueService;

@Service
public class DeclineOrderServiceImpl implements DeclineOrderService {
    private final OrderQueueService orderQueueService;
    private final OrderRepository orderRepository;

    @Autowired
    public DeclineOrderServiceImpl(OrderQueueService orderQueueService, OrderRepository orderRepository) {
        this.orderQueueService = orderQueueService;
        this.orderRepository = orderRepository;
    }

    @Override
    public void declineOrder(long orderId) {
        OrderEntity order = orderRepository.findById(orderId).get();
        order.setStatus(OrderStatus.DECLINED);
        orderRepository.save(order);

        orderQueueService.deleteFromQueue(orderId);
    }
}
