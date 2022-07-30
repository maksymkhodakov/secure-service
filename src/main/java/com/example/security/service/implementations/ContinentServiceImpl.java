package com.example.security.service.implementations;

import com.example.security.DTO.ContinentDto;
import com.example.security.DTO.PlanetDto;
import com.example.security.exceptions.ContinentNameNotFound;
import com.example.security.exceptions.ContinentNotFoundException;
import com.example.security.repo.ContinentRepo;
import com.example.security.service.interfaces.ContinentService;
import com.example.security.utils.mapper.ContinentMapper;
import com.example.security.utils.mapper.PlanetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ContinentServiceImpl implements ContinentService {
    private final ContinentRepo continentRepo;
    private final PlanetMapper planetMapper;
    private final ContinentMapper continentMapper;

    @Override
    public ContinentDto save(ContinentDto continentDto) {
        var continent = continentMapper.toEntity(continentDto);
        log.info("Saving continent to db");
        continentRepo.save(continent);
        return continentMapper.toDto(continent);
    }

    @Override
    public void delete(ContinentDto continentDto) {
        log.info("Deleting continent with name: {} from db", continentDto.getName());
        var continent = continentMapper.toEntity(continentDto);
        continentRepo.delete(continent);
    }

    @Override
    public List<ContinentDto> getByPlanet(PlanetDto planetDto) {
        log.info("Getting continents by planet: {}", planetDto.getName());
        var planet = planetMapper.toEntity(planetDto);
        var continents = continentRepo.findByPlanet(planet)
                .orElseThrow(() -> new ContinentNotFoundException(
                        "Continents on planet" + planetDto.getName()+ " not found"
                ));
        return continents.stream()
                .map(continentMapper::toDto)
                .toList();
    }

    @Override
    public ContinentDto getByName(String continentName) {
        log.info("Getting continent by name: {}", continentName);
        var continent = continentRepo.findByName(continentName)
                .orElseThrow(() -> new ContinentNameNotFound(
                        "Continent with name " + continentName + " not found"
                ));
        return continentMapper.toDto(continent);
    }
}
