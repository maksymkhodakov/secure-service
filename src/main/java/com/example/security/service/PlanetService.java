package com.example.security.service;

import com.example.security.DTO.PlanetDto;

public interface PlanetService {
    PlanetDto save(PlanetDto dto);
    PlanetDto get(Long id);
    PlanetDto getByName(String name);
}
