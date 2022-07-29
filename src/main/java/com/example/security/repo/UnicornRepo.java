package com.example.security.repo;

import com.example.security.domain.Unicorn;
import com.example.security.domain.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnicornRepo extends JpaRepository<Unicorn, Long> {
    Optional<Unicorn> findByName(String name);
    Optional<List<Unicorn>> findByColor(Color color);
}
