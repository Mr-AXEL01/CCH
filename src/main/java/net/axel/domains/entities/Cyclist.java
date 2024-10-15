package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cyclists")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cyclist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "first name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull(message = "age is required")
    @Column(name = "age", nullable = false)
    private LocalDate age;

    @NotBlank(message = "nationality is required")
    @Column(name = "nationality", nullable = false)
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}
