package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "competitions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Competition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Competition name is required")
    @Column(name = "competition_name", nullable = false)
    private String name;

    @NotNull(message = "Competition date is required")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotBlank(message = "Place is required")
    @Column(name = "place", nullable = false)
    private String place;

    @NotNull(message = "Distance is required")
    @Column(name = "distance", nullable = false)
    private double distance;
}
