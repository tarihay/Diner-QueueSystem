package ru.nsu.gorin.ooaid.new_diner.service;

import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.model.OrderQueueObject;

import java.util.Map;

public interface OrderQueueService {
    void addToQueue(OrderEntity order);
    void deleteFromQueue(long id);
    Map<Long, OrderQueueObject> getOrderQueue();
}
