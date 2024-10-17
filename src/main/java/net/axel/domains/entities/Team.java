package net.axel.domains.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "teams")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "team name is required")
    @Column(name = "team_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Cyclist> cyclists;

    public Team(String name) {
        this.name = name;
    }

    public Team(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
