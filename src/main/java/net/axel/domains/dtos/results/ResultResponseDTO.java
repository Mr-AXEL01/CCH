package net.axel.domains.dtos.results;

import jakarta.validation.constraints.NotNull;
import net.axel.domains.dtos.cyclists.EmbeddedCyclist;
import net.axel.domains.dtos.stages.EmbeddedStage;
import net.axel.domains.embeddeds.ResultKey;

import java.time.Duration;

public record ResultResponseDTO(
        @NotNull
        ResultKey id,

        @NotNull
        EmbeddedCyclist cyclist,

        @NotNull
        EmbeddedStage stage,

        @NotNull
        Duration time,

        @NotNull
        int rank
) {
}
