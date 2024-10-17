package net.axel.domains.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeamDto(
        @NotBlank(message = "Team name is required")
        String teamName
) {
}
