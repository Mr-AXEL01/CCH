package net.axel.services.interfaces;

import net.axel.domains.dtos.competitions.CompetitionDto;
import net.axel.domains.entities.Competition;

import java.util.List;
import java.util.UUID;

public interface ICompetitionService {
    List<Competition> getAllCompetitions();

    Competition getCompetitionById(UUID id);

    Competition saveCompetition(CompetitionDto dto);

    Competition updateCompetition(UUID id, CompetitionDto dto);

    void deleteCompetition(UUID id);
}
