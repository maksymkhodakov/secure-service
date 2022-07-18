package com.example.security.repo;

import com.example.security.domain.Droid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroidRepo extends JpaRepository<Droid, Long> {
    List<Droid> findAllByIdIn(List<Long> ids);
}
