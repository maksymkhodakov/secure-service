package com.example.fraudcheckerservice.repository;

import com.example.fraudcheckerservice.domain.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Long> {
}