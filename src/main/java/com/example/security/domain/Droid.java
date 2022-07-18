package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Setter
@Entity
@Table(name = "droids")
@AllArgsConstructor
@NoArgsConstructor
public class Droid extends AbstractEntity {
    private String name;
    private Unicorn unicorn;
    private List<Cupcake> cupcakes;
    private Boolean alive;

    public Droid(String name, Unicorn unicorn, Boolean alive) {
        this.name = name;
        this.unicorn = unicorn;
        this.alive = alive;
    }

    public Droid(String name, Boolean alive) {
        this.name = name;
        this.alive = alive;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unicorn_id")
    public Unicorn getUnicorn() {
        return unicorn;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "droid")
    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    @Column(name = "alive")
    public Boolean getAlive() {
        return alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Droid droid = (Droid) o;
        return getId() != null && Objects.equals(getId(), droid.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
