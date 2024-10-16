package net.axel.domains.embeddeds;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record ResultKey(
        @Column(name = "cyclist_id") UUID cyclistId,
        @Column(name = "stage_id") UUID stageId
) implements Serializable {
}
