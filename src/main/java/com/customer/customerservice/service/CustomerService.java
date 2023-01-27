package com.customer.customerservice.service;

import com.customer.customerservice.domain.data.CustomerRegistrationData;
import com.customer.customerservice.domain.dto.CustomerDto;

public interface CustomerService {
    CustomerDto registerCustomer(CustomerRegistrationData customerData);
}
