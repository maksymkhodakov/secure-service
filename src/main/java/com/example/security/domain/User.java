package com.example.security.domain;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;

@Entity
@Setter
@ToString
public class User extends AbstractEntity{

    private String name;

    private String username;

    private String password;

    private Collection<Role> roles = new ArrayList<>();

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @ManyToMany(fetch = EAGER)
    public Collection<Role> getRoles() {
        return roles;
    }

    public User(Long id, LocalDateTime created, LocalDateTime updated, String name, String username, String password, Collection<Role> roles) {
        super(id, created, updated);
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}