package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.GeneralResultDto;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.Competition;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.GeneralResult;
import net.axel.repositories.CyclistRepository;
import net.axel.repositories.GeneralResultRepository;
import net.axel.services.interfaces.ICompetitionService;
import net.axel.services.interfaces.ICyclistService;
import net.axel.services.interfaces.IGeneralResultService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GeneralResultService implements IGeneralResultService {

    private final GeneralResultRepository generalResultRepository;
    private final ICyclistService cyclistService;
    private final CyclistRepository cyclistRepository;
    private final ICompetitionService competitionService;

    @Override
    public List<GeneralResult> getAllGeneralResults() {
        return generalResultRepository.findAll();
    }

    @Override
    public GeneralResult getGeneralResultById(GeneralResultKey id) {
        return generalResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("general result not found by the ID :" + id));
    }

    @Override
    public GeneralResult saveGeneralResult(GeneralResultDto dto) {
        GeneralResultKey id = new GeneralResultKey(dto.cyclistId(), dto.competitionId());

        Competition competition = competitionService.getCompetitionById(dto.competitionId());
        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new RuntimeException("Cyclist not found with id :" + dto.cyclistId()));

        GeneralResult generalResult = new GeneralResult(id, cyclist, competition, Duration.ZERO, 0);
        return generalResultRepository.save(generalResult);
    }

    @Override
    public void deleteGeneralResult(GeneralResultKey id) {
        generalResultRepository.deleteById(id);
    }
}
