package net.axel.domains.dtos.results;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;
import java.util.UUID;

public record ResultDto(
        @NotNull(message = "cyclist ID is required for the result record.")
        UUID cyclistId,

        @NotNull(message = "stage ID is required for the result record.")
        UUID stageId,

        @NotNull(message = "time recorded for the cyclist for the result.")
        Duration time
) {
}
