package net.axel.services.implementations;

import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Team;
import net.axel.mappers.TeamMapper;
import net.axel.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void givenEmptyDatabase_whenGetAllTeams_thenReturnEmptyList() {
        when(teamRepository.findAll()).thenReturn(Collections.emptyList());

        var result = teamService.getAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void givenMultipleTeamsInDatabase_whenGetAllTeams_thenReturnAllTeams() {
        Team anotherTeam = new Team(UUID.randomUUID(), "Another Team");
        when(teamRepository.findAll()).thenReturn(List.of(team, anotherTeam));
        when(teamMapper.toResponseDto(team)).thenReturn(teamResponseDTO);
        when(teamMapper.toResponseDto(anotherTeam)).thenReturn(new TeamResponseDTO(anotherTeam.getId(), "Another Team", Collections.emptyList()));

        var result = teamService.getAll();

        assertEquals(2, result.size());
        assertEquals(teamResponseDTO, result.get(0));
        assertEquals("Another Team", result.get(1).name());
    }

    @Test
    void givenExistingTeamId_whenGetTeamById_thenReturnTeam() {
        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));
        when(teamMapper.toResponseDto(team)).thenReturn(teamResponseDTO);

        var result = teamService.getById(teamId);

        assertEquals(teamResponseDTO, result);
    }

    @Test
    void givenNonExistentTeamId_whenGetTeamById_thenThrowException() {
        when(teamRepository.findById(teamId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> teamService.getById(teamId));
        assertEquals("Entity not found with id: " + teamId, exception.getMessage());
    }

    @Test
    void givenNullId_whenGetById_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> teamService.getById(null));
    }


    @Test
    void givenValidTeamDto_whenCreateTeam_thenReturnCreatedTeam() {
        when(teamMapper.toEntity(teamDto)).thenReturn(team);
        when(teamRepository.save(team)).thenReturn(team);
        when(teamMapper.toResponseDto(team)).thenReturn(teamResponseDTO);

        var result = teamService.create(teamDto);

        assertEquals(teamResponseDTO, result);
    }

    @Test
    void givenDuplicateTeamName_whenCreateTeam_thenReturnCreatedTeam() {
        TeamDto duplicateTeamDto = new TeamDto("Test Team");
        when(teamMapper.toEntity(duplicateTeamDto)).thenReturn(team);
        when(teamRepository.save(team)).thenReturn(team);
        when(teamMapper.toResponseDto(team)).thenReturn(teamResponseDTO);

        var result = teamService.create(duplicateTeamDto);

        assertEquals(teamResponseDTO, result);
    }



    @Test
    void givenExistingTeamIdAndUpdatedDto_whenUpdateTeam_thenReturnUpdatedTeam() {
        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));
        TeamDto updatedTeamDto = new TeamDto("Updated Team");

        teamService.update(teamId, updatedTeamDto);

        assertEquals("Updated Team", team.getName());
    }

    @Test
    void givenNonExistentTeamId_whenUpdateTeam_thenThrowException() {
        TeamDto updatedTeamDto = new TeamDto("Updated Team");
        when(teamRepository.findById(teamId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> teamService.update(teamId, updatedTeamDto));
        assertEquals("Entity not found with id: " + teamId, exception.getMessage());
    }

    @Test
    void givenNullId_whenUpdateTeam_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> teamService.update(null, new TeamDto("Updated Team")));
    }


    @Test
    void givenExistingTeamId_whenDeleteTeam_thenTeamShouldBeDeleted() {
        when(teamRepository.existsById(teamId)).thenReturn(true).thenReturn(false);

        teamService.delete(teamId);

        assertFalse(teamRepository.existsById(teamId), "The team should no longer exist after deletion.");
    }

    @Test
    void givenNonExistentTeamId_whenDeleteTeam_thenThrowException() {
        when(teamRepository.existsById(teamId)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> teamService.delete(teamId));
        assertEquals("Entity not found with id: " + teamId, exception.getMessage());
    }

    @Test
    void givenNullId_whenDeleteTeam_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> teamService.delete(null));
    }
}