package net.axel.services.interfaces;

import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Team;

import java.util.UUID;

public interface ITeamService extends IBaseService<Team, TeamDto, TeamResponseDTO, UUID> {
}
