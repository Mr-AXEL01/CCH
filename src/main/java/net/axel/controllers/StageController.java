package net.axel.controllers;

import net.axel.domains.dtos.stages.StageDto;
import net.axel.domains.dtos.stages.StageResponseDTO;
import net.axel.domains.entities.Stage;
import net.axel.services.interfaces.IStageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(StageController.CONTROLLER_PATH)
public class StageController extends BaseController<Stage, StageDto, StageResponseDTO, UUID> {
    public final static String CONTROLLER_PATH = "/api/v1/stages";

    public StageController(IStageService stageService) {
        super(stageService);
    }
}
