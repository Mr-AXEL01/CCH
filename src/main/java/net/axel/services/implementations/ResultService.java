package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.ResultDto;
import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Result;
import net.axel.repositories.ResultRepository;
import net.axel.services.interfaces.IResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResultService implements IResultService {
    private final ResultRepository resultRepository;

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


        return null;
    }

    @Override
    public Result updateResult(ResultKey id, ResultDto dto) {
        return null;
    }

    @Override
    public void deleteResult(ResultKey id) {

    }
}
