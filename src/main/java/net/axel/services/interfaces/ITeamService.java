package net.axel.services.interfaces;

import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ITeamService {
    List<TeamResponseDTO> getAllTeams();

    TeamResponseDTO getTeamById(UUID id);

    TeamResponseDTO saveTeam(TeamDto dto);

    TeamResponseDTO updateTeam(UUID id, TeamDto dto);

    void deleteTeam(UUID id);
}
