package net.axel.controllers;

import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.services.interfaces.ITeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(TeamController.CONTROLLER_PATH)
@RequiredArgsConstructor
public class TeamController {
    public final static String CONTROLLER_PATH = "/api/v1/teams";
    private final ITeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        List<TeamResponseDTO> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable UUID id) {
        TeamResponseDTO team = teamService.getTeamById(id);
        return ResponseEntity.ok(team);
    }

    @PostMapping
    public ResponseEntity<TeamResponseDTO> createTeam(@RequestBody TeamDto dto) {
        TeamResponseDTO createdTeam = teamService.saveTeam(dto);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(@PathVariable UUID id, @RequestBody TeamDto dto) {
        TeamResponseDTO updatedTeam = teamService.updateTeam(id, dto);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteTeam(@PathVariable UUID id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
