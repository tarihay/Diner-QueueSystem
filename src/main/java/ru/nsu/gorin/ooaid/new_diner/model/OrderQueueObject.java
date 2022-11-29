package ru.nsu.gorin.ooaid.new_diner.model;

import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderItemEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;

import java.util.List;
import java.util.Set;

public class OrderQueueObject {
    private OrderEntity orderEntity;
    private Set<OrderItemQueueObject> orderItemQueueObjects;

    public OrderQueueObject(OrderEntity orderEntity,
                            Set<OrderItemQueueObject> orderItemQueueObject) {
        this.orderEntity = orderEntity;
        this.orderItemQueueObjects = orderItemQueueObject;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public String toString() {
        return "\nOrderQueueObject { \n" +
                "orderEntity:" + orderEntity.getUser().getNickname() +
                "\norderItemQueueObject: " + orderItemQueueObjects + "\n" +
                '}';
    }
}
