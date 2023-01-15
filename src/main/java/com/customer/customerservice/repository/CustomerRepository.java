package com.customer.customerservice.repository;

import com.customer.customerservice.domain.dto.CustomerFullName;
import com.customer.customerservice.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select new com.customer.customerservice.domain.dto." +
            "CustomerFullName(c.firstName, c.lastName) from Customer c where c.id = :id")
    CustomerFullName findCustomerFullName(Long id);

    @Query("select new com.customer.customerservice.domain.dto." +
            "CustomerFullName(c.firstName, c.lastName) from Customer c")
    List<CustomerFullName> findAllInfo();
}