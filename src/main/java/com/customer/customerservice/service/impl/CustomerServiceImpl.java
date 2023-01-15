package com.customer.customerservice.service.impl;

import com.customer.customerservice.domain.data.CustomerRegistrationData;
import com.customer.customerservice.domain.dto.CustomerDto;
import com.customer.customerservice.domain.dto.CustomerFullName;
import com.customer.customerservice.domain.entity.Customer;
import com.customer.customerservice.repository.CustomerRepository;
import com.customer.customerservice.service.CustomerService;
import com.customer.customerservice.service.CustomerValidator;
import com.example.fraudcheckerservice.domain.dto.FraudCheckDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    public static final String FRAUD_CHECK_API = "http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}";
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final RestTemplate restTemplate;

    @Override
    public CustomerDto registerCustomer(CustomerRegistrationData customerData) {
        customerValidator.validateRegistrationData(customerData);
        final Customer customer = new Customer(customerData);
        log.info("Customer with id: {} has been validated!", customer.getId());
        customerRepository.saveAndFlush(customer);
        fraudCheck(customer);
        return new CustomerDto(customer);
    }

    private void fraudCheck(Customer customer) {
        final FraudCheckDTO fraudCheckDTO = getCheckData(customer);
        if (isFraudster(fraudCheckDTO)) {
            customer.setFraudster(true);
            log.info("Customer with id {} is fraudster!", customer.getId());
        }
    }

    private boolean isFraudster(FraudCheckDTO fraudCheckDTO) {
        return nonNull(fraudCheckDTO) && fraudCheckDTO.isFraudster();
    }

    private FraudCheckDTO getCheckData(Customer customer) {
        return restTemplate.getForObject(
                FRAUD_CHECK_API,
                FraudCheckDTO.class,
                customer.getId()
        );
    }

    @Override
    public CustomerFullName getCustomerFullName(Long id) {
        return customerRepository.findCustomerFullName(id);
    }

    @Override
    public List<CustomerFullName> getCustomersInfo() {
        return customerRepository.findAllInfo();
    }
}
