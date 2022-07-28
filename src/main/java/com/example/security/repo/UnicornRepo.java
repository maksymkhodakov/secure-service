package com.example.security.repo;

import com.example.security.domain.Unicorn;
import com.example.security.domain.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnicornRepo extends JpaRepository<Unicorn, Long> {
    Unicorn findByName(String name);
    List<Unicorn> findByColor(Color color);
}
