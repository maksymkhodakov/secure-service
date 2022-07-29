package com.example.security.api;

import com.example.security.DTO.UnicornDto;
import com.example.security.domain.enums.Color;
import com.example.security.service.interfaces.UnicornService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/unicorn")
@RequiredArgsConstructor
public class UnicornResource {
    private final UnicornService unicornService;

    @GetMapping
    public ResponseEntity<UnicornDto> get(@RequestBody UnicornDto unicornDto) {
        return ResponseEntity.ok().body(unicornService.save(unicornDto));
    }

    @PostMapping
    public ResponseEntity<UnicornDto> save(@RequestBody UnicornDto unicornDto) {
        return ResponseEntity.ok().body(unicornService.save(unicornDto));
    }

    @GetMapping("/{name}")
    public ResponseEntity<UnicornDto> getByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok().body(unicornService.getByName(name));
    }

    @GetMapping("/get_by_color")
    public ResponseEntity<List<UnicornDto>> getByColor(@RequestParam Color color) {
        return ResponseEntity.ok().body(unicornService.getByColor(color));
    }
}
