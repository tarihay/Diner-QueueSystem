package ru.nsu.gorin.ooaid.new_diner.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true)
    @NotBlank
    private String nickname;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",
                    nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    nullable = false, updatable = false)
    )
    private List<RoleEntity> roles = new ArrayList<>();


    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public void addRoleToList(RoleEntity role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
