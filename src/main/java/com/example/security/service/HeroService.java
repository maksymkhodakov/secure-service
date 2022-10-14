package com.example.security.service;

import com.example.security.DTO.HeroDto;

public interface HeroService {
    HeroDto getLastCreated(String city);
}
