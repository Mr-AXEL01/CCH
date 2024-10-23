package net.axel.domains.dtos.teams;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EmbeddedTeam(

        @NotNull
        UUID id,

        @NotBlank
        String name
) {
}
