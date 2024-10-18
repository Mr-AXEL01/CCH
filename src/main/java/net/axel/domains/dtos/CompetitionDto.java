package net.axel.domains.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CompetitionDto(
        @NotBlank(message = "competition name is required")
        String competitionName,

        @NotBlank(message = "competition place is necessary")
        String place,

        @NotNull(message = "Competition distance is required")
        double distance,

        @NotNull(message = "competition date is required")
        LocalDate date
) {
}
