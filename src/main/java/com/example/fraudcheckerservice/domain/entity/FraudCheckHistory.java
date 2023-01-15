package com.example.fraudcheckerservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fraud_check_history")
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "is_fraudster")
    private boolean isFraudster;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
