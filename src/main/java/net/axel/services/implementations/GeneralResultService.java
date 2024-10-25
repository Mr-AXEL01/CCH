package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import net.axel.domains.dtos.generalResults.GeneralResultDto;
import net.axel.domains.dtos.generalResults.GeneralResultResponseDTO;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.Competition;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.GeneralResult;
import net.axel.mappers.GeneralResultMapper;
import net.axel.repositories.CompetitionRepository;
import net.axel.repositories.CyclistRepository;
import net.axel.repositories.GeneralResultRepository;
import net.axel.services.interfaces.IGeneralResultService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GeneralResultService extends BaseService<GeneralResult, GeneralResultDto, GeneralResultResponseDTO, GeneralResultKey> implements IGeneralResultService {

    private final CyclistRepository cyclistRepository;
    private final CompetitionRepository competitionRepository;

    public GeneralResultService(GeneralResultRepository generalResultRepository, GeneralResultMapper mapper, CyclistRepository cyclistRepository, CompetitionRepository competitionRepository) {
        super(generalResultRepository, mapper);
        this.cyclistRepository = cyclistRepository;
        this.competitionRepository = competitionRepository;
    }

    @Override
    protected void updateEntity(GeneralResult entity, GeneralResultDto dto) {
        Competition competition = competitionRepository.findById(dto.competitionId())
                .orElseThrow(() -> new RuntimeException("competition not found with id: " + dto.competitionId()));

        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new RuntimeException("Cyclist not found with id: " + dto.cyclistId()));

        entity.setCyclist(cyclist)
                .setCompetition(competition);
    }
}
