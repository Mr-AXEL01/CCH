package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import net.axel.domains.embeddeds.ResultKey;

import java.io.Serializable;
import java.time.Duration;
import java.util.UUID;

@Entity
@Table(name = "results")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result implements Serializable {
    @EmbeddedId
    private ResultKey id;

    @ManyToOne
    @MapsId("cyclistId")
    @JoinColumn(name = "cyclist_id")
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("stageId")
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @NotNull(message = "time is required")
    @Column(name = "time", nullable = false)
    private Duration time;

    @NotNull(message = "rank is required")
    @Column(name = "rank", nullable = false)
    private int rank;
}
