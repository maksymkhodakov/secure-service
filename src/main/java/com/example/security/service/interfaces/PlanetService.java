package com.example.security.service.interfaces;

import com.example.security.DTO.PlanetDto;

public interface PlanetService {
    PlanetDto save(PlanetDto dto);
    PlanetDto get(Long id);
}
