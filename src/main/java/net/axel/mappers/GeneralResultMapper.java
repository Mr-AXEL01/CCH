package net.axel.mappers;

import net.axel.domains.dtos.generalResults.GeneralResultDto;
import net.axel.domains.dtos.generalResults.GeneralResultResponseDTO;
import net.axel.domains.entities.GeneralResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneralResultMapper extends BaseMapper<GeneralResult, GeneralResultResponseDTO, GeneralResultDto> {
}
