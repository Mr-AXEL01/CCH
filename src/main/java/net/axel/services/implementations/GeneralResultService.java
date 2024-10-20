package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.GeneralResultDto;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.Competition;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.GeneralResult;
import net.axel.repositories.GeneralResultRepository;
import net.axel.services.interfaces.ICompetitionService;
import net.axel.services.interfaces.ICyclistService;
import net.axel.services.interfaces.IGeneralResultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GeneralResultService implements IGeneralResultService {

    private final GeneralResultRepository generalResultRepository;
    private final ICyclistService cyclistService;
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
        Cyclist cyclist = cyclistService.getCyclistById(dto.cyclistId());

        GeneralResult generalResult = new GeneralResult(id, cyclist, competition);
        return generalResultRepository.save(generalResult);
    }

    @Override
    public GeneralResult updateGeneralResult(GeneralResultKey id, GeneralResultDto dto) {
        GeneralResult generalResult = getGeneralResultById(id);

        GeneralResultKey newId = new GeneralResultKey(dto.cyclistId(), dto.competitionId());
        Competition competition = competitionService.getCompetitionById(dto.competitionId());
        Cyclist cyclist = cyclistService.getCyclistById(dto.cyclistId());

        generalResult.setId(newId)
                .setCyclist(cyclist)
                .setCompetition(competition);

        return generalResultRepository.save(generalResult);
    }

    @Override
    public void deleteGeneralResult(GeneralResultKey id) {
        generalResultRepository.deleteById(id);
    }
}
