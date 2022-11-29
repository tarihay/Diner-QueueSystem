package ru.nsu.gorin.ooaid.new_diner.service;


import ru.nsu.gorin.ooaid.new_diner.model.RoleDTO;
import ru.nsu.gorin.ooaid.new_diner.model.UserDTO;
import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;

public interface RegistrationService {
    UserEntity registerUser(UserDTO userDTO);

    UserEntity addRoleToUser(String nickname, String roleName);

    UserEntity registerAdmin(UserDTO userDTO);
}
