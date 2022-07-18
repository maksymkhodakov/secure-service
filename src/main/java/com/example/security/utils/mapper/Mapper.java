package com.example.security.utils.mapper;

import com.example.security.DTO.AbstractDto;
import com.example.security.domain.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {
    E toEntity(D dto);
    D toDto(E entity);
}
