package net.axel.services.implementations;

import net.axel.domains.dtos.TeamDto;
import net.axel.domains.entities.Team;
import net.axel.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    private Team team;
    private TeamDto teamDto;

    @BeforeEach
    void setUP() {
        team = new Team()
                .setId(UUID.randomUUID())
                .setName("morocco");
        teamDto = new TeamDto("usa");
    }

    @Test
    public void givenNoTeam_whenGetAllTeams_thenReturnEmptyList() {
        when(teamRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(teamService.getAllTeams().isEmpty());
    }

    @Test
    public void givenId_whenGetTeamById_thenReturnTeam() {
        when(teamRepository.findById(team.getId())).thenReturn(Optional.of(team));
        Team result = teamService.getTeamById(team.getId());
        assertEquals("morocco", result.getName());
    }

    @Test
    public void givenId_whenGetTeamById_thenReturnException() {
        when(teamRepository.findById(team.getId())).thenThrow(new IllegalArgumentException("Team not found with id: " + team.getId()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> teamService.getTeamById(team.getId()));
        assertEquals("Team not found with id: " + team.getId(), exception.getMessage());
    }

    @Test
    public void givenTeam_whenSaveTeam_thenReturnTeam() {
        Team savedTeam = new Team(teamDto.teamName());
        when(teamRepository.save(any(Team.class))).thenReturn(savedTeam);
        Team result = teamService.saveTeam(teamDto);
        assertEquals("usa", result.getName());
    }
}