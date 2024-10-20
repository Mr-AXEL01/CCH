package net.axel.services.interfaces;

import net.axel.domains.dtos.ResultDto;
import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Result;

import java.util.List;

public interface IResultService {
    List<Result> getAllResults();

    Result getResultById(ResultKey id);

    Result saveResult(ResultDto dto);

    Result updateResult(ResultKey id, ResultDto dto);

    void deleteResult(ResultKey id);
}
