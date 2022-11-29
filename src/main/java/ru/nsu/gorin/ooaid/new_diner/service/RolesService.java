package ru.nsu.gorin.ooaid.new_diner.service;

import ru.nsu.gorin.ooaid.new_diner.model.RoleDTO;
import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;

import java.util.List;

public interface RolesService {
    RoleEntity getRoleById(long id);
}
