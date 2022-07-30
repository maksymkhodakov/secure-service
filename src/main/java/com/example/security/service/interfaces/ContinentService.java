package com.example.security.service.interfaces;

import com.example.security.DTO.ContinentDto;
import com.example.security.DTO.PlanetDto;

public interface ContinentService {
    ContinentDto save(ContinentDto continentDto);
    void delete(ContinentDto continentDto);
    ContinentDto getByPlanet(PlanetDto planet);
    ContinentDto getByName(String continentName);
}
