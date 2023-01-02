package com.example.security.service;

import com.example.security.DTO.ReportDto;
import com.example.security.domain.Report;
import com.example.security.repo.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportMetadataService implements IMetadata<Report> {
    private final ReportRepository reportRepository;

    @Override
    public List<Report> extractData() {
        return reportRepository.findAll()
                .stream()
                .peek(it -> it.setId(null))
                .toList();
    }

    @Override
    public void uploadData(Report data) {
        reportRepository.save(data);
    }
}
