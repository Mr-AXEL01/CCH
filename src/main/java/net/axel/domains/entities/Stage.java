package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import net.axel.domains.enums.StageType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "stages")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Stage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "stage number is required")
    @Column(name = "stage_number", nullable = false)
    private int number;

    @NotBlank(message = "start location is required")
    @Column(name = "start_location", nullable = false)
    private String startLocation;

    @NotBlank(message = "end location is required")
    @Column(name = "end_location", nullable = false)
    private String endLocation;

    @NotNull(message = "start date time is required")
    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime StartDateTime;

    @NotNull(message = "stage type is required")
    @Column(name = "stage_type", nullable = false)
    private StageType stageType;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @OneToMany(mappedBy = "stage")
    Set<Result> results;

    public Stage(int number, String startLocation, String endLocation, LocalDateTime startDateTime, StageType stageType, Competition competition) {
        this.number = number;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        StartDateTime = startDateTime;
        this.stageType = stageType;
        this.competition = competition;
    }
}
