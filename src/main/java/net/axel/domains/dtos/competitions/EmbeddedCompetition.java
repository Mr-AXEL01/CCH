package net.axel.domains.dtos.competitions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EmbeddedCompetition(
        @NotNull
        UUID id,

        @NotBlank
        String name,

        @NotBlank
        String place,

        @NotNull
        double distance,

        @NotNull
        LocalDate date
) {
}
