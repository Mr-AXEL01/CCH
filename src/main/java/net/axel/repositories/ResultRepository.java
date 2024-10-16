package net.axel.repositories;

import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, ResultKey> {
}
