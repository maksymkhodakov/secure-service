package com.example.security.service;

import java.util.UUID;

public interface ContactService {
    void updateNumberById(UUID id, String number);
}
