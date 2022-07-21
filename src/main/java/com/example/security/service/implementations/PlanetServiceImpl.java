package com.example.security.service.implementations;

import com.example.security.DTO.PlanetDto;
import com.example.security.exceptions.PlanetException;
import com.example.security.repo.PlanetRepo;
import com.example.security.service.interfaces.PlanetService;
import com.example.security.utils.mapper.PlanetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {
    private final PlanetRepo repository;
    private final PlanetMapper mapper;

    @Override
    public PlanetDto save(PlanetDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public PlanetDto get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new PlanetException(String.format("Unable to get by id %d", id))));
    }
}
