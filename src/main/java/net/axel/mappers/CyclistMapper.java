package net.axel.mappers;

import net.axel.domains.dtos.cyclists.CyclistDto;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.domains.entities.Cyclist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CyclistMapper extends BaseMapper<Cyclist, CyclistResponseDTO, CyclistDto> {
}
