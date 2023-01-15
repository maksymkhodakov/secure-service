package com.customer.customerservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerFullName {
    private String firstName;
    private String lastName;
}
