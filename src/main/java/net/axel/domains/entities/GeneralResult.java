package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import net.axel.domains.embeddeds.GeneralResultKey;

import java.io.Serializable;
import java.time.Duration;

@Entity
@Table(name = "general_results")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GeneralResult implements Serializable {
    @EmbeddedId
    private GeneralResultKey id;

    @ManyToOne
    @MapsId("cyclistId")
    @JoinColumn(name = "cyclist_id")
    private Cyclist cyclist;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @NotNull(message = "general time is required.")
    @Column(name = "general_time", nullable = false)
    private Duration generalTime;

    @NotNull(message = "general rank is required")
    @Column(name = "general_rank", nullable = false)
    private int generalRank;
}
