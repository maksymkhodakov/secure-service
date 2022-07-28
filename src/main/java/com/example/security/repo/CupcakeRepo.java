package com.example.security.repo;

import com.example.security.domain.Cupcake;
import com.example.security.domain.Droid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CupcakeRepo extends JpaRepository<Cupcake, Long> {
    List<Cupcake> findAllByIdIn(List<Long> ids);
    List<Cupcake> findByDroid(Droid droid);
}
