package net.axel.services.interfaces;

import net.axel.domains.dtos.TeamDto;
import net.axel.domains.entities.Team;

import java.util.List;
import java.util.UUID;

public interface ITeamService {
    List<Team> getAllTeams();
    Team getTeamById(UUID id);
    Team saveTeam(TeamDto dto);
    Team updateTeam(UUID id, TeamDto dto);
    void deleteTeam(UUID id);
}
