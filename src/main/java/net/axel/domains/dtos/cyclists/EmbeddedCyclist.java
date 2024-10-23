package net.axel.domains.dtos.cyclists;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EmbeddedCyclist(
        @NotNull
        UUID id,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotNull
        LocalDate birthdate,

        @NotBlank
        String nationality
) {
}
