package net.axel.controllers;

import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Team;
import net.axel.services.interfaces.ITeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(TeamController.CONTROLLER_PATH)
public class TeamController extends BaseController<Team, TeamDto, TeamResponseDTO, UUID>{
    public final static String CONTROLLER_PATH = "/api/v1/teams";

    public TeamController(ITeamService teamService) {
        super(teamService);
    }

}
