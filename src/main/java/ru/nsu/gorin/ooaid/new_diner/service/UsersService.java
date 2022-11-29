package ru.nsu.gorin.ooaid.new_diner.service;

import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;

import java.util.List;

public interface UsersService {
    UserEntity getUserByNickname(String nickname);

    UserEntity getUserById(long id);

    List<UserEntity> getAllUsers();

    UserEntity addRoleToUser(long userId, long roleId);
}
