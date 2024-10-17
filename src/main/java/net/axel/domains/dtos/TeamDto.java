package net.axel.domains.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeamDto(
        @NotBlank String teamName
) {
}
