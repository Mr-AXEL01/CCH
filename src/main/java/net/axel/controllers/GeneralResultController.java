package net.axel.controllers;

import net.axel.domains.dtos.generalResults.GeneralResultDto;
import net.axel.domains.dtos.generalResults.GeneralResultResponseDTO;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.GeneralResult;
import net.axel.services.interfaces.IGeneralResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResultController.CONTROLLER_PATH)
public class GeneralResultController extends BaseController<GeneralResult, GeneralResultDto, GeneralResultResponseDTO, GeneralResultKey> {
    public final static String CONTROLLER_PATH = "/api/v1/general_results";

    public GeneralResultController(IGeneralResultService generalResultService) {
        super(generalResultService);
    }
}
