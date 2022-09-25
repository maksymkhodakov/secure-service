package com.example.security.service.interfaces;

import com.example.security.DTO.HeroDto;

public interface HeroService {
    HeroDto getLastCreated(String city);
}
