package com.example.security.domain;

import com.example.security.domain.enums.Color;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "unicorns")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unicorn extends AbstractEntity {
    private String name;
    private List<Droid> droids;
    private Color color;

    public Unicorn(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "unicorn")
    public List<Droid> getDroids() {
        return droids;
    }

    @Column(name = "color")
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Unicorn unicorn = (Unicorn) o;
        return getId() != null && Objects.equals(getId(), unicorn.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
