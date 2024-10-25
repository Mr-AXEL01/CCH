package net.axel.services.interfaces;

import net.axel.domains.dtos.results.ResultDto;
import net.axel.domains.dtos.results.ResultResponseDTO;
import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Result;

import java.util.List;

public interface IResultService extends IBaseService<Result, ResultDto, ResultResponseDTO, ResultKey> {
}
