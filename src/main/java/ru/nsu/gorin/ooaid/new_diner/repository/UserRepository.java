package ru.nsu.gorin.ooaid.new_diner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity save(UserEntity user);
    UserEntity findById(long id);

    UserEntity findByNickname(String nickname);
    void deleteById(long id);
}
