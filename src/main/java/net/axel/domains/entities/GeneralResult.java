package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
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

    @Column(name = "general_time")
    private Duration generalTime;

    @Column(name = "general_rank")
    private int generalRank;
}
