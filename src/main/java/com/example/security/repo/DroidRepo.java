package com.example.security.repo;

import com.example.security.domain.Droid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DroidRepo extends JpaRepository<Droid, Long> {
    List<Droid> findAllByIdIn(List<Long> ids);
}
