package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@NamedEntityGraph(name = "Client.contacts",
        attributeNodes = @NamedAttributeNode("contactNumbers"))
public class Client extends AbstractEntity {
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(name = "client_contact",
            joinColumns = @JoinColumn(name = "client_id"),
            foreignKey = @ForeignKey(name = "fk_client_contact__client"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"),
            inverseForeignKey = @ForeignKey(name = "fk_client_contact__contact"))
    private List<Contact> contactNumbers = new ArrayList<>();

    @Column(name = "roles_id")
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Role> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
