package net.axel.repositories;

import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.GeneralResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralResultRepository extends JpaRepository<GeneralResult, GeneralResultKey> {
}
