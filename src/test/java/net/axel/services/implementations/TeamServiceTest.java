package net.axel.services.implementations;

import net.axel.domains.entities.Team;
import net.axel.repositories.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TeamServiceTest {

    @Test
    public void testGetTeamById() {
    TeamRepository teamRepositoryMock = Mockito.mock(TeamRepository.class);
    UUID teamId = UUID.randomUUID();
    when(teamRepositoryMock.findById(teamId)).thenReturn(Optional.of(new Team(teamId, "morocco")));
    TeamService teamService = new TeamService(teamRepositoryMock);

    Team team = teamService.getTeamById(teamId);

    assertEquals("morocco", team.getName());
    }


}