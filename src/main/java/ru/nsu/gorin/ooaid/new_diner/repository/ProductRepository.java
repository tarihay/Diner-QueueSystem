package ru.nsu.gorin.ooaid.new_diner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(long id);
    List<ProductEntity> findAll();
}
