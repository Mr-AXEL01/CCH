package net.axel.services.implementations;

import net.axel.domains.dtos.StageDto;
import net.axel.domains.entities.Stage;
import net.axel.services.interfaces.IStageService;

import java.util.List;
import java.util.UUID;

public class StageService implements IStageService {
    @Override
    public List<Stage> getAllStages() {
        return List.of();
    }

    @Override
    public Stage getStageById(UUID id) {
        return null;
    }

    @Override
    public Stage saveStage(StageDto dto) {
        return null;
    }

    @Override
    public Stage updateStage(UUID id, StageDto dto) {
        return null;
    }

    @Override
    public void deleteStage(UUID id) {

    }
}
