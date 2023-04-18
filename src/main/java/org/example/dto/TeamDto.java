package org.example.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TeamDto {
    private String name;
    private BigDecimal bank;
    private List<PlayerDto> players;
}
