package net.axel.controllers;

import net.axel.domains.dtos.competitions.CompetitionDto;
import net.axel.domains.dtos.competitions.CompetitionResponseDTO;
import net.axel.domains.entities.Competition;
import net.axel.services.interfaces.ICompetitionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(CompetitionController.CONTROLLER_PATH)
public class CompetitionController extends BaseController<Competition, CompetitionDto, CompetitionResponseDTO, UUID> {
    public final static String CONTROLLER_PATH = "/api/v1/competitions";

    public CompetitionController(ICompetitionService competitionService) {
        super(competitionService);
    }
}
