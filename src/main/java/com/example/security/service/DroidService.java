package com.example.security.service;

import com.example.security.DTO.DroidDto;
import com.example.security.DTO.UnicornDto;
import java.util.List;
import java.util.Set;

public interface DroidService {
    DroidDto getDroidByUnicorn(UnicornDto unicornDto);
    List<DroidDto> getDroidByAlive(Boolean alive);
    Set<DroidDto> getDroidByName(String name);
}
