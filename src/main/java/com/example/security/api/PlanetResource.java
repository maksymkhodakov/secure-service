package com.example.security.api;

import com.example.security.DTO.PlanetDto;
import com.example.security.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/planet")
@RestController
@RequiredArgsConstructor
public class PlanetResource {
    private final PlanetService planetService;

    @PostMapping
    public ResponseEntity<PlanetDto> save(@RequestBody PlanetDto dto) {
        return ResponseEntity.ok(planetService.save(dto));
    }

    @GetMapping
    public ResponseEntity<PlanetDto> get(@RequestParam("id") Long id) {
        return ResponseEntity.ok(planetService.get(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<PlanetDto> getByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok(planetService.getByName(name));
    }
}
