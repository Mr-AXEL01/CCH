package net.axel.domains.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TeamResponseDTO(
        @NotNull
        UUID id,
        @NotBlank(message = "Team name is required")
        String teamName
) {
}
