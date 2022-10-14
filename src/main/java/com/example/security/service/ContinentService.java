package com.example.security.service;

import com.example.security.DTO.ContinentDto;
import com.example.security.DTO.PlanetDto;

import java.util.List;

public interface ContinentService {
    ContinentDto save(ContinentDto continentDto);
    void delete(ContinentDto continentDto);
    List<ContinentDto> getByPlanet(PlanetDto planet);
    ContinentDto getByName(String continentName);
}
