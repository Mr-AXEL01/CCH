package net.axel.domains.dtos.generalResults;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GeneralResultDto(
        @NotNull(message = "cyclist ID is required for the sub.")
        UUID cyclistId,

        @NotNull(message = "Competition ID is required for the cyclist Sub.")
        UUID competitionId
) {
}
