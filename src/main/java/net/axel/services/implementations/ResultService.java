package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.results.ResultDto;
import net.axel.domains.dtos.results.ResultResponseDTO;
import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.Result;
import net.axel.domains.entities.Stage;
import net.axel.mappers.BaseMapper;
import net.axel.mappers.ResultMapper;
import net.axel.repositories.CyclistRepository;
import net.axel.repositories.ResultRepository;
import net.axel.repositories.StageRepository;
import net.axel.services.interfaces.ICyclistService;
import net.axel.services.interfaces.IResultService;
import net.axel.services.interfaces.IStageService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ResultService extends BaseService<Result, ResultDto, ResultResponseDTO, ResultKey> implements IResultService {

    private final CyclistRepository cyclistRepository;
    private final StageRepository stageRepository;

    public ResultService(ResultRepository resultRepository, ResultMapper mapper, CyclistRepository cyclistRepository, StageRepository stageRepository) {
        super(resultRepository, mapper);
        this.cyclistRepository = cyclistRepository;
        this.stageRepository = stageRepository;
    }

    @Override
    public ResultResponseDTO create(ResultDto dto) {
        ResultKey id = new ResultKey(dto.cyclistId(), dto.stageId());

        Cyclist cyclist = cyclistRepository.findById(dto.cyclistId())
                .orElseThrow(() -> new RuntimeException("Cyclist not found with id :" + dto.cyclistId()));

        Stage stage = stageRepository.findById(dto.stageId())
                .orElseThrow(() -> new RuntimeException("Stage not found with id: " + dto.stageId()));

        Result savedResult = new Result(id, cyclist, stage, dto.time());
        return mapper.toResponseDto(savedResult);
    }

    @Override
    protected void updateEntity(Result entity, ResultDto dto) {
        entity.setTime(dto.time());
    }
}
