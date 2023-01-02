package com.example.security.domain;

import com.example.security.domain.convertors.ActiveYearsConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
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
    @Convert(converter = ActiveYearsConverter.class)
    private List<Integer> activeYears;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}