package net.axel.mappers;

import net.axel.domains.dtos.results.ResultDto;
import net.axel.domains.dtos.results.ResultResponseDTO;
import net.axel.domains.entities.Result;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultMapper extends BaseMapper<Result, ResultResponseDTO, ResultDto> {
}
