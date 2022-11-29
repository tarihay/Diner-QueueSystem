package ru.nsu.gorin.ooaid.new_diner.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.nsu.gorin.ooaid.new_diner.model.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity user;

    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    @Column(name = "order_items")
    private Set<OrderItemEntity> orderItems = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "user=" + user.getNickname() +
                ", status=" + status +
                ", orderItems=" + orderItems +
                '}';
    }
}
