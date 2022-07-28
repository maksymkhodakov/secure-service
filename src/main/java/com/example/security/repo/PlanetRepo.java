package com.example.security.repo;

import com.example.security.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
    Planet findByName(String name);
}
