package net.axel.mappers;

import net.axel.domains.dtos.competitions.CompetitionDto;
import net.axel.domains.dtos.competitions.CompetitionResponseDTO;
import net.axel.domains.entities.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper extends BaseMapper<Competition, CompetitionResponseDTO, CompetitionDto>{
}
