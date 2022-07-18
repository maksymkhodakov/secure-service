package com.example.security.repo;

import com.example.security.domain.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepo extends JpaRepository<Continent, Long> {
}
