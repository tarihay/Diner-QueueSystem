package ru.nsu.gorin.ooaid.new_diner.model;

import java.util.Arrays;

public class OrderDTO {
    private OrderItemDTO orderItems[];

    public OrderItemDTO[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItemDTO[] orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderItems=" + Arrays.toString(orderItems) +
                '}';
    }
}
