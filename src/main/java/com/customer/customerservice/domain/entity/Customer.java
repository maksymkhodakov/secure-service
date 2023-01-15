package com.customer.customerservice.domain.entity;

import com.customer.customerservice.domain.interfaces.ICustomer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "customers")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update customers set deleted = 1 where id = ?0")
public class Customer extends AbstractEntity implements ICustomer {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "is_fraudster")
    private boolean isFraudster;

    public Customer(ICustomer iCustomer) {
        this.firstName = iCustomer.getFirstName();
        this.lastName = iCustomer.getLastName();
        this.email = iCustomer.getEmail();
    }
}
