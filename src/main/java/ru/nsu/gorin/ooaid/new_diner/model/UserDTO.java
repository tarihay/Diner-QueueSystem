package ru.nsu.gorin.ooaid.new_diner.model;

import ru.nsu.gorin.ooaid.new_diner.entities.RoleEntity;

import java.util.ArrayList;
import java.util.Collection;

public class UserDTO {
    private String nickname;

    private String password;

    private String firstName;

    public UserDTO(String nickname, String password, String firstName) {
        this.nickname = nickname;
        this.password = password;
        this.firstName = firstName;
    }

    private Collection<RoleEntity> roles = new ArrayList<>();

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Collection<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleEntity> roles) {
        this.roles = roles;
    }
}
