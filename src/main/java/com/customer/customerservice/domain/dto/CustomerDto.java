package com.customer.customerservice.domain.dto;

import com.customer.customerservice.domain.interfaces.ICustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements ICustomer {
    private String firstName;
    private String lastName;
    private String email;

    public CustomerDto(ICustomer iCustomer) {
        this.firstName = iCustomer.getFirstName();
        this.lastName = iCustomer.getLastName();
        this.email = iCustomer.getEmail();
    }
}
