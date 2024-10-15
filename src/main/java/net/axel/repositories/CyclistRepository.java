package net.axel.repositories;

import net.axel.domains.entities.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, UUID> {
}
