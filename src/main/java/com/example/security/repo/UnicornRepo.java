package com.example.security.repo;

import com.example.security.domain.Unicorn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnicornRepo extends JpaRepository<Unicorn, Long> {

}
