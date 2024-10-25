package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import net.axel.domains.dtos.competitions.CompetitionDto;
import net.axel.domains.dtos.competitions.CompetitionResponseDTO;
import net.axel.domains.entities.Competition;
import net.axel.mappers.CompetitionMapper;
import net.axel.repositories.CompetitionRepository;
import net.axel.services.interfaces.ICompetitionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class CompetitionService extends BaseService<Competition, CompetitionDto, CompetitionResponseDTO, UUID> implements ICompetitionService {

    public CompetitionService(CompetitionRepository competitionRepository, CompetitionMapper mapper) {
        super(competitionRepository, mapper);
    }

    @Override
    protected void updateEntity(Competition entity, CompetitionDto dto) {
        entity.setDate(dto.date())
                .setDistance(dto.distance())
                .setName(dto.name())
                .setPlace(dto.place());
    }
}
