package net.axel.domains.dtos.generalResults;

import jakarta.validation.constraints.NotNull;
import net.axel.domains.embeddeds.GeneralResultKey;

import java.time.Duration;

public record EmbeddedGeneralResult(
        @NotNull
        GeneralResultKey id,

        @NotNull
        Duration generalTime,

        @NotNull
        int generalRank
) {
}
