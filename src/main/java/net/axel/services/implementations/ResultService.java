package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.ResultDto;
import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.Result;
import net.axel.domains.entities.Stage;
import net.axel.repositories.CyclistRepository;
import net.axel.repositories.ResultRepository;
import net.axel.services.interfaces.ICyclistService;
import net.axel.services.interfaces.IResultService;
import net.axel.services.interfaces.IStageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResultService implements IResultService {
    private final ResultRepository resultRepository;
    private final ICyclistService cyclistService;
    private final CyclistRepository cyclistRepository;
    private final IStageService stageService;

    @Override
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result getResultById(ResultKey id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("result not found by the ID :" + id));
    }

    @Override
    public Result saveResult(ResultDto dto) {
        ResultKey id = new ResultKey(dto.cyclistId(), dto.stageId());

        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new RuntimeException("Cyclist not found with id :" + dto.cyclistId()));

        Stage stage = stageService.getStageById(dto.stageId());

        Result result = new Result(id, cyclist, stage, dto.time());
        return resultRepository.save(result);
    }

    @Override
    public Result updateResult(ResultKey id, ResultDto dto) {
        Result result = getResultById(id);

        result.setTime(dto.time());
        return resultRepository.save(result);
    }

    @Override
    public void deleteResult(ResultKey id) {
        resultRepository.deleteById(id);
    }
}
