package com.customer.customerservice.service.impl;

import com.customer.customerservice.domain.data.CustomerRegistrationData;
import com.customer.customerservice.exceptions.InvalidCustomerRegistrationDataException;
import com.customer.customerservice.service.CustomerValidator;
import org.springframework.stereotype.Service;

import static io.micrometer.common.util.StringUtils.isEmpty;
import static java.util.Objects.nonNull;

@Service
public class CustomerValidatorImpl implements CustomerValidator {
    @Override
    public void validateRegistrationData(CustomerRegistrationData customerData) {
        if (!isValidRegistrationData(customerData)) {
            throw new InvalidCustomerRegistrationDataException("Customer registration data is not valid! Please, check data again");
        }
    }

    private static boolean isValidRegistrationData(CustomerRegistrationData customerData) {
        return nonNull(customerData.getId()) && customerData.getId() > 0
                && nonNull(customerData.getEmail()) && !isEmpty(customerData.getEmail())
                && nonNull(customerData.getFirstName()) && nonNull(customerData.getLastName());
    }
}
