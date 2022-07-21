package com.example.security.utils.mapper;

import com.example.security.DTO.UnicornDto;
import com.example.security.domain.Unicorn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnicornMapper extends AbstractMapper<Unicorn, UnicornDto> {
    @Autowired
    public UnicornMapper() {
        super(Unicorn.class, UnicornDto.class);
    }
}
