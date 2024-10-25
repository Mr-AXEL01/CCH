package net.axel.mappers;

import net.axel.domains.dtos.stages.StageDto;
import net.axel.domains.dtos.stages.StageResponseDTO;
import net.axel.domains.entities.Stage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StageMapper extends BaseMapper<Stage, StageResponseDTO, StageDto>{
}
