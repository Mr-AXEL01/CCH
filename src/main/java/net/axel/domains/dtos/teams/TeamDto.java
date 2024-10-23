package net.axel.domains.dtos.teams;

import jakarta.validation.constraints.NotBlank;

public record TeamDto(
        @NotBlank(message = "Team name is required")
        String name
) {
}
