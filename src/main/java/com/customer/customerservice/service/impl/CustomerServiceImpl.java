package com.customer.customerservice.service.impl;

import com.customer.customerservice.domain.data.CustomerRegistrationData;
import com.customer.customerservice.domain.dto.CustomerDto;
import com.customer.customerservice.domain.dto.CustomerFullName;
import com.customer.customerservice.domain.entity.Customer;
import com.customer.customerservice.repository.CustomerRepository;
import com.customer.customerservice.service.CustomerService;
import com.customer.customerservice.service.CustomerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;

    @Override
    public CustomerDto registerCustomer(CustomerRegistrationData customerData) {
        customerValidator.validateRegistrationData(customerData);
        log.info("Customer with id: {} has been validated!", customerData.getId());
        customerRepository.save(new Customer(customerData));
        log.info("Customer with id: {} has been saved to db!", customerData.getId());
        return new CustomerDto(customerData);
    }

    @Override
    public CustomerFullName getCustomerFullName(Long id) {
        return customerRepository.findCustomerFullName(id);
    }
}
