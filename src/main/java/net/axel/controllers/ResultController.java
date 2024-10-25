package net.axel.controllers;

import net.axel.domains.dtos.results.ResultDto;
import net.axel.domains.dtos.results.ResultResponseDTO;
import net.axel.domains.embeddeds.ResultKey;
import net.axel.domains.entities.Result;
import net.axel.services.interfaces.IResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResultController.CONTROLLER_PATH)
public class ResultController extends BaseController<Result, ResultDto, ResultResponseDTO, ResultKey> {
    public final static String CONTROLLER_PATH = "/api/v1/results";

    public ResultController(IResultService resultService) {
        super(resultService);
    }
}
