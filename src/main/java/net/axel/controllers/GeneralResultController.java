package net.axel.controllers;

import net.axel.domains.dtos.generalResults.GeneralResultDto;
import net.axel.domains.dtos.generalResults.GeneralResultResponseDTO;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.GeneralResult;
import net.axel.services.interfaces.IGeneralResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(GeneralResultController.CONTROLLER_PATH)
public class GeneralResultController extends BaseController<GeneralResult, GeneralResultDto, GeneralResultResponseDTO, GeneralResultKey> {
    public final static String CONTROLLER_PATH = "/api/v1/general_results";

    public GeneralResultController(IGeneralResultService generalResultService) {
        super(generalResultService);
    }


    @GetMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<GeneralResultResponseDTO> getByEmbeddedId(
            @PathVariable("competitionId") UUID competitionId,
            @PathVariable("cyclistId") UUID cyclistId) {

        GeneralResultKey id = new GeneralResultKey(cyclistId, competitionId);

        GeneralResultResponseDTO result = baseService.getById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{competitionId}/{cyclistId}")
    public ResponseEntity<Void> delete(
            @PathVariable("competitionId") UUID competitionId,
            @PathVariable("cyclistId") UUID cyclistId) {

        GeneralResultKey id = new GeneralResultKey(cyclistId, competitionId);

        baseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
