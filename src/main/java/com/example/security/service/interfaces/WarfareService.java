package com.example.security.service.interfaces;

import java.util.List;

public interface WarfareService {
    String battle(Long idOfDroidThatAttacks, Long idOfDroidThatDefends);
    List<Long> decideWhoAttacks(Long firstCandidate, Long secondCandidate);
}
