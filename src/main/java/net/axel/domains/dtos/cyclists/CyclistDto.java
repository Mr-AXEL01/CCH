package net.axel.domains.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CyclistDto(
        @NotBlank(message = "first name is required")
        String firstName,

        @NotBlank(message = "last name is required")
        String lastName,

        @NotNull(message = "age is required")
        LocalDate birthdate,

        @NotBlank(message = "nationality is required")
        String nationality,

        @NotNull(message = "team ID is required")
        UUID teamId
) {
}
