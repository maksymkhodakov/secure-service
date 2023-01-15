package com.customer.customerservice.api;

import com.customer.customerservice.domain.data.CustomerRegistrationData;
import com.customer.customerservice.domain.dto.CustomerDto;
import com.customer.customerservice.domain.dto.CustomerFullName;
import com.customer.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerRegistrationData customerData) {
        return ResponseEntity.ok(customerService.registerCustomer(customerData));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<CustomerFullName> getInfo(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomerFullName(Long.valueOf(id)));
    }
}
