package net.axel.controllers;

import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.services.interfaces.ITeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
