package com.example.security.utils.mapper;

import com.example.security.DTO.ContinentDto;
import com.example.security.domain.Continent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper extends AbstractMapper<Continent, ContinentDto> {
    @Autowired
    public ContinentMapper() {
        super(Continent.class, ContinentDto.class);
    }
}
