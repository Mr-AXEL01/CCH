package net.axel.controllers;

import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.TeamResponseDTO;
import net.axel.services.interfaces.ITeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TeamController.CONTROLLER_PATH)
@RequiredArgsConstructor
public class TeamController {
    public final static String CONTROLLER_PATH = "api/v1/teams";
    private final ITeamService teamService;

    @GetMapping
    public List<TeamResponseDTO> getAllTeams() {
        return teamService.getAllTeams()
                .stream()
                .map(team -> new TeamResponseDTO(team.getId(), team.getName()))
                .toList();
    }
}
