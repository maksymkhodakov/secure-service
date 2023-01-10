package com.customer.customerservice.service;

import com.customer.customerservice.domain.data.CustomerRegistrationData;

public interface CustomerValidator {
    void validateRegistrationData(CustomerRegistrationData customerData);
}
