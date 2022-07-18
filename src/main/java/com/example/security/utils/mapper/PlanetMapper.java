package com.example.security.utils.mapper;

import com.example.security.DTO.PlanetDto;
import com.example.security.domain.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanetMapper extends AbstractMapper<Planet, PlanetDto>{
    @Autowired
    public PlanetMapper() {
        super(Planet.class, PlanetDto.class);
    }
}
