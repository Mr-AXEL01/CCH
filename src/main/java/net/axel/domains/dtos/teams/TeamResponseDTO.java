package net.axel.domains.dtos.teams;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.domains.dtos.cyclists.EmbeddedCyclist;

import java.util.List;
import java.util.UUID;

public record TeamResponseDTO(
        @NotNull
        UUID id,

        @NotBlank(message = "Team name is required")
        String name,

        List<EmbeddedCyclist> cyclists
) {
}
