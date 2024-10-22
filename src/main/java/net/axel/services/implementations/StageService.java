package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.StageDto;
import net.axel.domains.entities.Competition;
import net.axel.domains.entities.Stage;
import net.axel.repositories.StageRepository;
import net.axel.services.interfaces.ICompetitionService;
import net.axel.services.interfaces.IStageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class StageService implements IStageService {

    private final StageRepository stageRepository;
    private final ICompetitionService competitionService;

    @Override
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @Override
    public Stage getStageById(UUID id) {
        return stageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error finding stage with id :" +id));
    }

    @Override
    public Stage saveStage(StageDto dto) {
        Competition competition = competitionService.getCompetitionById(dto.competitionId());
        Stage stage = new Stage(dto.stageNumber(), dto.startLocation(), dto.endLocation(), dto.startDateTime(), dto.stageType(), competition);
        return stageRepository.save(stage);
    }

    @Override
    public Stage updateStage(UUID id, StageDto dto) {
        Stage stage = getStageById(id);
        Competition competition = competitionService.getCompetitionById(dto.competitionId());

        stage.setNumber(dto.stageNumber())
                .setStartLocation(dto.startLocation())
                .setEndLocation(dto.endLocation())
                .setStartDateTime(dto.startDateTime())
                .setStageType(dto.stageType())
                .setCompetition(competition);

        return stageRepository.save(stage);
    }

    @Override
    public void deleteStage(UUID id) {
        stageRepository.deleteById(id);
    }
}
