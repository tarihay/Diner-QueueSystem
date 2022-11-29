package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.repository.RoleRepository;
import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;
import ru.nsu.gorin.ooaid.new_diner.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
    private final RoleRepository roleRepository;

    @Autowired
    public RolesServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity getRoleById(long id) {
        return roleRepository.findById(id);
    }

}
