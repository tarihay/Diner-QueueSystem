package ru.nsu.gorin.ooaid.new_diner.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.gorin.ooaid.new_diner.repository.RoleRepository;
import ru.nsu.gorin.ooaid.new_diner.repository.UserRepository;
import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;
import ru.nsu.gorin.ooaid.new_diner.service.UsersService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional
public class UsersServiceImpl implements UsersService, UserDetailsService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByNickname(nickname);
        if (user == null) {
            throw new UsernameNotFoundException("User not found in the db");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getNickname(), user.getPassword(), authorities);
    }

    @Override
    public UserEntity getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity addRoleToUser(long userId, long roleId) {
        UserEntity user = userRepository.findById(userId);
        RoleEntity role = roleRepository.findById(roleId);

        user.addRoleToList(role);
        userRepository.save(user);

        return user;
    }

}
