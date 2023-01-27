package com.example.fraudcheckerservice.api;

import com.example.fraudcheckerservice.domain.dto.FraudCheckDTO;
import com.example.fraudcheckerservice.service.FraudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {
    private final FraudService fraudService;

    @GetMapping("/{customerId}")
    public FraudCheckDTO isFraudster(@PathVariable Long customerId) {
        return fraudService.isFraudulentCustomer(customerId);
    }
}
