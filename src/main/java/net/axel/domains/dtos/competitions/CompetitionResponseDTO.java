package net.axel.domains.dtos.competitions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.domains.dtos.generalResults.EmbeddedGeneralResult;
import net.axel.domains.dtos.stages.EmbeddedStage;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CompetitionResponseDTO(
        @NotNull
        UUID id,

        @NotBlank
        String name,

        @NotBlank
        String place,

        @NotNull
        double distance,

        @NotNull
        LocalDate date,

        List<EmbeddedStage> stages,

        List<EmbeddedGeneralResult> generalResults
) {
}
