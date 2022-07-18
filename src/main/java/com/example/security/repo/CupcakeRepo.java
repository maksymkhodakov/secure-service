package com.example.security.repo;

import com.example.security.domain.Cupcake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CupcakeRepo extends JpaRepository<Cupcake, Long> {
    List<Cupcake> findAllByIdIn(List<Long> ids);
}
