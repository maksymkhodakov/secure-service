package com.example.security.DTO;

import com.example.security.domain.enums.Filling;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CupcakeDto extends AbstractDto {
    private Filling filling;
    private Long droidId;
}
