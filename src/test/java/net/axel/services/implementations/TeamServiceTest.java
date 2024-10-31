package net.axel.services.implementations;

import net.axel.domains.dtos.cyclists.EmbeddedCyclist;
import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Team;
import net.axel.mappers.BaseMapper;
import net.axel.mappers.TeamMapper;
import net.axel.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private TeamMapper teamMapper;

    @InjectMocks
    private TeamService teamService;

    private Team team;
    private TeamDto teamDto;
    private TeamResponseDTO teamResponseDTO;
    private final UUID teamId = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        team = new Team(teamId, "test Team");
        teamDto = new TeamDto("test Team");
        teamResponseDTO = new TeamResponseDTO(teamId, "Test Team", Collections.emptyList());
    }

    @Test
    void givenTeamsInDatabase_whenGetAllTeams_thenReturnAllTeams() {
        when(teamRepository.findAll()).thenReturn(Collections.singletonList(team));
        when(teamMapper.toResponseDto(team)).thenReturn(teamResponseDTO);

        var result = teamService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(teamResponseDTO, result.get(0));
    }

}