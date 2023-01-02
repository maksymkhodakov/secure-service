package com.example.security.domain.subdomain.repos;

import com.example.security.domain.subdomain.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findFirstByStatusOrderByCreatedAt(Application.Status status);
}
