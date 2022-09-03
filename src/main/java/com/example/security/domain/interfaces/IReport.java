package com.example.security.domain.interfaces;

import java.time.LocalDateTime;

public interface IReport {
    Long getId();

    LocalDateTime getCreated();

    LocalDateTime getUpdated();

    String getName();

    String getType();
}
