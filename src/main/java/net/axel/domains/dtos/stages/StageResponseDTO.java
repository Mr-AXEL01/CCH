package net.axel.domains.dtos.stages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.domains.dtos.competitions.EmbeddedCompetition;
import net.axel.domains.dtos.results.EmbeddedResult;
import net.axel.domains.enums.StageType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record StageResponseDTO(
        @NotNull
        UUID id,

        @NotNull
        int number,

        @NotBlank
        String startLocation,

        @NotBlank
        String endLocation,

        @NotNull
        LocalDateTime startDateTime,

        @NotNull
        StageType stageType,

        EmbeddedCompetition competition,

        List<EmbeddedResult> results
) {
}
