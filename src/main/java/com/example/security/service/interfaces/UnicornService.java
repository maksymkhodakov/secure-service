package com.example.security.service.interfaces;

import com.example.security.DTO.UnicornDto;

public interface UnicornService {
    UnicornDto save(UnicornDto dto);

    UnicornDto get(Long id);
}
