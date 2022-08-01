package com.example.security.api;

import com.example.security.DTO.CupcakeDto;
import com.example.security.DTO.DroidDto;
import com.example.security.service.interfaces.CupcakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cupcakes")
@RequiredArgsConstructor
public class CupcakeResource {
    private final CupcakeService cupcakeService;

    @PostMapping
    ResponseEntity<CupcakeDto> saveCupcake(@RequestBody CupcakeDto dto) {
        return ResponseEntity.ok(cupcakeService.saveCupcake(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<CupcakeDto> getCupcake(@PathVariable Long id) {
        return ResponseEntity.ok(cupcakeService.getCupcakeById(id));
    }

    @GetMapping
    ResponseEntity<List<CupcakeDto>> getByDroid(@RequestBody DroidDto droidDto) {
        return ResponseEntity.ok(cupcakeService.getByDroid(droidDto));
    }
}
