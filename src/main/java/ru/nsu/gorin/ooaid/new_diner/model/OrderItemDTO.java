package ru.nsu.gorin.ooaid.new_diner.model;

public class OrderItemDTO {
    private long productId;

    private int amount;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "productId=" + productId +
                ", amount=" + amount +
                '}';
    }
}
