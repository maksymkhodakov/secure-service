package com.example.security.utils.mapper;

import com.example.security.DTO.HeroDto;
import com.example.security.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper extends AbstractMapper<Hero, HeroDto>{
    @Autowired
    HeroMapper() {
        super(Hero.class, HeroDto.class);
    }
}
