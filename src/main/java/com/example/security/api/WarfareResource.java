package com.example.security.api;

import com.example.security.DTO.DroidDto;
import com.example.security.service.WarfareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/warfare")
@AllArgsConstructor
public class WarfareResource {
    private final WarfareService warfareService;

    @GetMapping("/letsBattle")
    public String battle(@RequestBody DroidDto firstDroid,
                         @RequestBody DroidDto secondDroid) {
        List<Long> listOfWarriors = warfareService.decideWhoAttacks(firstDroid.getId(), secondDroid.getId());
        return warfareService.battle(listOfWarriors.get(0), listOfWarriors.get(1));
    }
}
