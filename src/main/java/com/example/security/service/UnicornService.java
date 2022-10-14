package com.example.security.service;

import com.example.security.DTO.UnicornDto;
import com.example.security.domain.enums.Color;
import java.util.List;

public interface UnicornService {
    UnicornDto save(UnicornDto dto);
    UnicornDto get(Long id);
    UnicornDto getByName(String name);
    List<UnicornDto> getByColor(Color color);
}
