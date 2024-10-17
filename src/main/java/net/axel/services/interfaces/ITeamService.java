package net.axel.services.interfaces;

import net.axel.domains.entities.Team;

import java.util.List;
import java.util.UUID;

public interface ITeamService {
    List<Team> getAllTeams();
    Team getTeamById(UUID id);
    Team saveTeam(Team team);
    Team updateTeam(Team team);
    void deleteTeam(UUID id);
}
