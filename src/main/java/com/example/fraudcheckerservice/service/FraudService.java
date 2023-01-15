package com.example.fraudcheckerservice.service;

import com.example.fraudcheckerservice.domain.dto.FraudCheckDTO;

public interface FraudService {
    FraudCheckDTO isFraudulentCustomer(Long customerId);
}
