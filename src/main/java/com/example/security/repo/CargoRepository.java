package com.example.security.repo;

import com.example.security.domain.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CargoRepository extends JpaRepository<Cargo, Long>, JpaSpecificationExecutor<Cargo> {
    @Query("SELECT Cargo FROM Cargo c WHERE LOWER(c.description) LIKE LOWER(:description)")
    Page<Cargo> getNecessaryCargos(String description, Pageable pageable);
}
