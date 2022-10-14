package com.example.security.service;

import com.example.security.DTO.CupcakeDto;
import com.example.security.DTO.DroidDto;
import java.util.List;

public interface CupcakeService {
    CupcakeDto saveCupcake(CupcakeDto dto);
    CupcakeDto getCupcakeById(Long id);
    List<CupcakeDto> getByDroid(DroidDto droidDto);
}
