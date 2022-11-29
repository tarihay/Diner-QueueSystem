package ru.nsu.gorin.ooaid.new_diner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findById(long id);
    RoleEntity findByName(String name);

    List<RoleEntity> findAll();
}
