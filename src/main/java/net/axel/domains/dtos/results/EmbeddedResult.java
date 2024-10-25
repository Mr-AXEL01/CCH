package net.axel.domains.dtos.results;

import jakarta.validation.constraints.NotNull;
import net.axel.domains.embeddeds.ResultKey;

import java.time.Duration;

public record EmbeddedResult(
        @NotNull
        ResultKey id,

        @NotNull
        Duration time,

        int rank
) {
}
