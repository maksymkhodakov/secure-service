package com.example.security.repo;

import com.example.security.domain.Continent;
import com.example.security.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepo extends JpaRepository<Continent, Long> {
    Continent findByPlanet(Planet planet);
    Continent findByName(String continentName);
}
