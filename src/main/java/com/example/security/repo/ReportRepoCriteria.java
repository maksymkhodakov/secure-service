package com.example.security.repo;

import com.example.security.domain.Report;

import java.util.List;

public interface ReportRepoCriteria {
    List<Report> getAll();
    Report getById(Long id);
}
