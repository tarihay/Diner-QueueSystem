package ru.nsu.gorin.ooaid.new_diner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;

import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findById(long orderId);
}
