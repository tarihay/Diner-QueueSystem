package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.model.OrderStatus;
import ru.nsu.gorin.ooaid.new_diner.repository.OrderRepository;
import ru.nsu.gorin.ooaid.new_diner.service.CompleteOrderService;
import ru.nsu.gorin.ooaid.new_diner.service.OrderQueueService;

@Service
public class CompleteOrderServiceImpl implements CompleteOrderService {
    private OrderQueueService orderQueueService;
    private OrderRepository orderRepository;

    @Autowired
    public CompleteOrderServiceImpl(OrderQueueService orderQueueService, OrderRepository orderRepository) {
        this.orderQueueService = orderQueueService;
        this.orderRepository = orderRepository;
    }

    @Override
    public void completeOrder(long orderId) {
        OrderEntity order = orderRepository.findById(orderId).get();
        order.setStatus(OrderStatus.DONE);
        orderRepository.save(order);

        orderQueueService.deleteFromQueue(orderId);
    }
}
