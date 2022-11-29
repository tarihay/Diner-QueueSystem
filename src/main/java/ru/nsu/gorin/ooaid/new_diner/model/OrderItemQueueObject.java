package ru.nsu.gorin.ooaid.new_diner.model;

import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;

public class OrderItemQueueObject {
    private ProductEntity product;
    private int amount;

    public OrderItemQueueObject(ProductEntity product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderItemQueueObject{" +
                "product=" + product.getName() +
                ", amount=" + amount +
                '}';
    }
}
