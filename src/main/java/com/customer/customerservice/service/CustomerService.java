package com.customer.customerservice.service;

import com.customer.customerservice.domain.data.CustomerRegistrationData;
import com.customer.customerservice.domain.dto.CustomerDto;
import com.customer.customerservice.domain.dto.CustomerFullName;

import java.util.List;

public interface CustomerService {
    CustomerDto registerCustomer(CustomerRegistrationData customerData);

    CustomerFullName getCustomerFullName(Long id);

    List<CustomerFullName> getCustomersInfo();
}
