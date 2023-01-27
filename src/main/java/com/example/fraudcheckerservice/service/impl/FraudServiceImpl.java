package com.example.fraudcheckerservice.service.impl;

import com.example.fraudcheckerservice.domain.dto.FraudCheckDTO;
import com.example.fraudcheckerservice.domain.entity.FraudCheckHistory;
import com.example.fraudcheckerservice.repository.FraudCheckHistoryRepository;
import com.example.fraudcheckerservice.service.FraudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudServiceImpl implements FraudService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public FraudCheckDTO isFraudulentCustomer(Long customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory
                        .builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return new FraudCheckDTO(false);
    }
}
