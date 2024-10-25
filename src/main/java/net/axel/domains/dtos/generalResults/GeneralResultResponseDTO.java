package net.axel.domains.dtos.generalResults;

import jakarta.validation.constraints.NotNull;
import net.axel.domains.dtos.competitions.EmbeddedCompetition;
import net.axel.domains.dtos.cyclists.EmbeddedCyclist;
import net.axel.domains.embeddeds.GeneralResultKey;

import java.time.Duration;

public record GeneralResultResponseDTO(
        @NotNull
        GeneralResultKey id,

        @NotNull
        EmbeddedCyclist cyclist,

        @NotNull
        EmbeddedCompetition competition,

        @NotNull
        Duration generalTime,

        @NotNull
        int generalRank
) {
}
