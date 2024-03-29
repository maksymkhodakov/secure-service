package com.example.security.repo;

import com.example.security.domain.CargoShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CargoShipRepository extends JpaRepository<CargoShip, Long>, JpaSpecificationExecutor<CargoShip> {
}
