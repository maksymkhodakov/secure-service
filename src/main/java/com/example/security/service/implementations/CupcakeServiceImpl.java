package com.example.security.service.implementations;

import com.example.security.DTO.CupcakeDto;
import com.example.security.DTO.DroidDto;
import com.example.security.domain.Droid;
import com.example.security.exceptions.CupcakeDroidNotFound;
import com.example.security.exceptions.CupcakeIdNotFound;
import com.example.security.repo.CupcakeRepo;
import com.example.security.service.interfaces.CupcakeService;
import com.example.security.utils.mapper.CupcakeMapper;
import com.example.security.utils.mapper.DroidMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("defaultCupcakesService")
@Slf4j
@AllArgsConstructor
@Transactional
public class CupcakeServiceImpl implements CupcakeService {
    private final CupcakeMapper cupcakeMapper;
    private final CupcakeRepo cupcakeRepo;
    private final DroidMapper droidMapper;

    @Override
    public CupcakeDto saveCupcake(CupcakeDto dto) {
        log.info("saving cupcake to db");
        var cupcake = cupcakeMapper.toEntity(dto);
        cupcakeRepo.save(cupcake);
        return dto;
    }

    @Override
    public CupcakeDto getCupcakeById(Long id) {
        log.info("getting cupcake by id: " + id);
        var cupcake = cupcakeRepo.findById(id).orElseThrow(() ->
                new CupcakeIdNotFound("Cupcake by id " + id + " not found"));
        return cupcakeMapper.toDto(cupcake);
    }

    @Override
    public List<CupcakeDto> getByDroid(DroidDto droidDto) {
        log.info("getting cupcake by droids");
        var droid = droidMapper.toEntity(droidDto);
        var cupcakes = cupcakeRepo.findByDroid(droid).orElseThrow(() ->
                new CupcakeDroidNotFound("cupcake's droid not found"));
        return cupcakes.stream()
                .map(cupcakeMapper::toDto)
                .toList();
    }
}
