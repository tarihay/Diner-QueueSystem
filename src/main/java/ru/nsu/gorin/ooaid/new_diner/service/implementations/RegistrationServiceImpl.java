package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.ooaid.new_diner.model.UserDTO;
import ru.nsu.gorin.ooaid.new_diner.repository.RoleRepository;
import ru.nsu.gorin.ooaid.new_diner.repository.UserRepository;
import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;
import ru.nsu.gorin.ooaid.new_diner.service.RegistrationService;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity registerUser(UserDTO userDTO) {
        UserEntity user = mapUserDTOToUserEntity(userDTO);

        userRepository.save(user);

        user = addRoleToUser(user.getNickname(), "USER");

        return user;
    }

    @Override
    public UserEntity addRoleToUser(String nickname, String roleName) {
        UserEntity user = userRepository.findByNickname(nickname);

        RoleEntity role = roleRepository.findByName(roleName);
        user.addRoleToList(role);
        userRepository.save(user);

        return user;
    }

    @Override
    public UserEntity registerAdmin(UserDTO userDTO) {
        UserEntity user = mapUserDTOToUserEntity(userDTO);

        userRepository.save(user);

        user = addRoleToUser(user.getNickname(), "ADMIN");

        return user;
    }

    private UserEntity mapUserDTOToUserEntity(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setFirstName(userDTO.getFirstName());
        user.setNickname(userDTO.getNickname());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return user;
    }
}
