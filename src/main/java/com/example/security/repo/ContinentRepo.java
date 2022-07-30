package com.example.security.repo;

import com.example.security.domain.Continent;
import com.example.security.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContinentRepo extends JpaRepository<Continent, Long> {
    Optional<List<Continent>> findByPlanet(Planet planet);
    Optional<Continent> findByName(String continentName);
}
