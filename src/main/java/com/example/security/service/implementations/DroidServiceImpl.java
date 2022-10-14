package com.example.security.service.implementations;

import com.example.security.DTO.DroidDto;
import com.example.security.DTO.UnicornDto;
import com.example.security.exceptions.DroidNotFound;
import com.example.security.repo.DroidRepo;
import com.example.security.service.DroidService;
import com.example.security.utils.mapper.DroidMapper;
import com.example.security.utils.mapper.UnicornMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

@Service("droidDefaultService")
@Slf4j
@Transactional
@RequiredArgsConstructor
public class DroidServiceImpl implements DroidService {
    private final DroidMapper droidMapper;
    private final DroidRepo droidRepo;
    private final UnicornMapper unicornMapper;

    @Override
    public DroidDto getDroidByUnicorn(UnicornDto unicornDto) {
        log.info("getting droid by unicornDto");
        var unicorn = unicornMapper.toEntity(unicornDto);
        var droid = droidRepo.findDroidByUnicorn(unicorn).orElseThrow(() ->
                new DroidNotFound("droid not found by unicorn: " + unicornDto));
        return droidMapper.toDto(droid);
    }

    @Override
    public List<DroidDto> getDroidByAlive(Boolean alive) {
        log.info("getting all droids by bool value: " + alive);
        var droids = droidRepo.findDroidByAlive(alive).orElseThrow(() ->
                new DroidNotFound("droids not found"));
        return droids.stream()
                .map(droidMapper::toDto)
                .toList();
    }

    @Override
    public Set<DroidDto> getDroidByName(String name) {
        var droids = droidRepo.findDroidByName(name).orElseThrow(() ->
                new DroidNotFound("no droid with this name"));
        return droids.stream()
                .map(droidMapper::toDto)
                .collect(toSet());
    }
}
