package com.example.security.domain;

import com.example.security.domain.enums.Filling;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cupcakes")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cupcake extends AbstractEntity {

    private Filling filling;
    private Droid droid;

    @Column(name = "filling")
    public Filling getFilling() {
        return filling;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "droid_id")
    public Droid getDroid() {
        return droid;
    }

    public Cupcake(Filling filling) {
        this.filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cupcake cupcake = (Cupcake) o;
        return getId() != null && Objects.equals(getId(), cupcake.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
