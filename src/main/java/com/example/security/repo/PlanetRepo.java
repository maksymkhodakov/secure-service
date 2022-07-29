package com.example.security.repo;

import com.example.security.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
    Optional<Planet> findByName(String name);
}
