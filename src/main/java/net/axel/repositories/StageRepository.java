package net.axel.repositories;

import net.axel.domains.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StageRepository extends JpaRepository<Stage, UUID> {
}
