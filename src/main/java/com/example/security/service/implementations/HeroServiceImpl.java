package com.example.security.service.implementations;

import com.example.security.DTO.HeroDto;
import com.example.security.exceptions.HeroNotFound;
import com.example.security.repo.HeroRepo;
import com.example.security.service.interfaces.HeroService;
import com.example.security.utils.mapper.HeroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {
    private final HeroRepo heroRepo;
    private final HeroMapper mapper;

    @Override
    public HeroDto getLastCreated(String city) {
        final var hero = heroRepo.findLastCreatedHeroInCity(city)
                .orElseThrow(() -> new HeroNotFound("Hero not found!"));
        return mapper.toDto(hero);
    }
}
