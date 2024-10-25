package net.axel.domains.dtos.stages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.domains.enums.StageType;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmbeddedStage(

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
        StageType stageType
) {
}
