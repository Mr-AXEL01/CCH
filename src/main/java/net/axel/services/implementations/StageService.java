package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import net.axel.domains.dtos.stages.StageDto;
import net.axel.domains.dtos.stages.StageResponseDTO;
import net.axel.domains.entities.Competition;
import net.axel.domains.entities.Stage;
import net.axel.mappers.StageMapper;
import net.axel.repositories.CompetitionRepository;
import net.axel.repositories.StageRepository;
import net.axel.services.interfaces.IStageService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class StageService extends BaseService<Stage, StageDto, StageResponseDTO, UUID> implements IStageService {

    private final CompetitionRepository competitionRepository;

    public StageService(StageRepository stageRepository, StageMapper mapper, CompetitionRepository competitionRepository) {
        super(stageRepository, mapper);
        this.competitionRepository = competitionRepository;
    }

    @Override
    public StageResponseDTO create(StageDto dto) {
        Competition competition = competitionRepository.findById(dto.competitionId())
                .orElseThrow(() -> new RuntimeException("Competition not found with ID :" + dto.competitionId()));

        Stage savedStage = new Stage(dto.number(), dto.startLocation(), dto.endLocation(), dto.startDateTime(), dto.stageType(), competition);
        return mapper.toResponseDto(repository.save(savedStage));
    }

    @Override
    protected void updateEntity(Stage entity, StageDto dto) {
        Competition competition = competitionRepository.findById(dto.competitionId())
                .orElseThrow(() -> new RuntimeException("Competition not found with ID :" + dto.competitionId()));

        entity.setNumber(dto.number())
                .setStartLocation(dto.startLocation())
                .setEndLocation(dto.endLocation())
                .setStartDateTime(dto.startDateTime())
                .setStageType(dto.stageType())
                .setCompetition(competition);
    }
}
