package net.axel.services.interfaces;

import net.axel.domains.dtos.competitions.CompetitionDto;
import net.axel.domains.dtos.competitions.CompetitionResponseDTO;
import net.axel.domains.entities.Competition;

import java.util.UUID;

public interface ICompetitionService extends IBaseService<Competition, CompetitionDto, CompetitionResponseDTO, UUID> {
}
