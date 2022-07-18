package com.example.security.service.implementations;

import com.example.security.DTO.UnicornDto;
import com.example.security.repo.UnicornRepo;
import com.example.security.utils.mapper.UnicornMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UnicornServiceImpl implements com.example.security.service.interfaces.UnicornService {
    private final UnicornRepo repository;
    private final UnicornMapper mapper;

    @Override
    public UnicornDto save(UnicornDto dto) {
        log.info("Saving unicorn {} to db", dto.getName());
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public UnicornDto get(Long id) {
        var unicorn = repository.findById(id).orElseThrow();
        log.info("Getting unicorn {} to db", unicorn.getName());
        return mapper.toDto(unicorn);
    }
}
