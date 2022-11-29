package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderItemEntity;
import ru.nsu.gorin.ooaid.new_diner.model.OrderItemQueueObject;
import ru.nsu.gorin.ooaid.new_diner.model.OrderQueueObject;
import ru.nsu.gorin.ooaid.new_diner.repository.OrderRepository;
import ru.nsu.gorin.ooaid.new_diner.service.OrderQueueService;

import java.util.*;

@Service
public class OrderQueueServiceImpl implements OrderQueueService {
    private final OrderRepository orderRepository;

    private Map<Long, OrderQueueObject> orderQueue = new HashMap<>();

    @Autowired
    public OrderQueueServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addToQueue(OrderEntity orderEntity) {
        Set<OrderItemQueueObject> orderItems = new HashSet<>();

        Set<OrderItemEntity> orderItemEntities = orderEntity.getOrderItems();
        for (OrderItemEntity orderItemEntity : orderItemEntities) {
            OrderItemQueueObject orderItem = new OrderItemQueueObject(
                    orderItemEntity.getProduct(), orderItemEntity.getAmount());
            orderItems.add(orderItem);
        }

        OrderQueueObject order = new OrderQueueObject(orderEntity, orderItems);

        orderQueue.put(orderEntity.getId(), order);
    }

    @Override
    public void deleteFromQueue(long id) {
        orderQueue.remove(id);
    }

    @Override
    public Map<Long, OrderQueueObject> getOrderQueue() {
        return orderQueue;
    }
}
