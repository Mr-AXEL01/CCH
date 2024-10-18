package net.axel.services.interfaces;

import net.axel.domains.dtos.StageDto;
import net.axel.domains.entities.Stage;

import java.util.List;
import java.util.UUID;

public interface IStageService {
    List<Stage> getAllStages();

    Stage getStageById(UUID id);

    Stage saveStage(StageDto dto);

    Stage updateStage(UUID id, StageDto dto);

    void deleteStage(UUID id);
}
