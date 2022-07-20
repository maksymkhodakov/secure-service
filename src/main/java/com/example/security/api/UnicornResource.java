package com.example.security.api;

import com.example.security.DTO.UnicornDto;
import com.example.security.service.interfaces.UnicornService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
