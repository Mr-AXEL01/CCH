package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.StageDto;
import net.axel.domains.entities.Stage;
import net.axel.repositories.StageRepository;
import net.axel.services.interfaces.IStageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class StageService implements IStageService {

    private final StageRepository stageRepository;

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
