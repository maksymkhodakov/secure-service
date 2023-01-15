package com.customer.customerservice.domain.data;

import com.customer.customerservice.domain.interfaces.ICustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationData implements ICustomer {
    private String firstName;
    private String lastName;
    private String email;
}
