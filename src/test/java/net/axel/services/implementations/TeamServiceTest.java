package net.axel.services.implementations;

import net.axel.domains.entities.Team;
import net.axel.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    private Team team;

    @BeforeEach
    void setUP() {
        team = new Team()
                .setId(UUID.randomUUID())
                .setName("morocco");
    }

    @Test
    public void givenId_whenGetTeamById_thenReturnTeam() {
        when(teamRepository.findById(team.getId())).thenReturn(Optional.of(team));
        Team result = teamService.getTeamById(team.getId());
        assertEquals("morocco", result.getName());
    }

    @Test
    public void givenId_whenGetTeamById_thenReturnNull() {
        when(teamRepository.findById(team.getId())).thenReturn(Optional.empty());
        Team result = teamService.getTeamById(team.getId());
        assertNull(result);
    }


}