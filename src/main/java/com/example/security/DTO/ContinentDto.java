package com.example.security.DTO;

import com.example.security.domain.Hero;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContinentDto extends AbstractDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PlanetDto planet;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<HeroDto> heroes;
}
