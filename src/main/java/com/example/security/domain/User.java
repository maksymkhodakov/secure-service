package com.example.security.domain;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Cacheable
@NamedEntityGraph(name = "graph.roles", attributeNodes = @NamedAttributeNode("roles"))
public class User extends AbstractEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active_years")
    private String activeYears;

    @ManyToMany(mappedBy = "users")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    @ToString.Exclude
    private Set<Role> roles = new HashSet<>();

    public User(Long id, LocalDateTime created, LocalDateTime updated, String name, String username, String password, Set<Role> roles) {
        super(id, created, updated);
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {}
}