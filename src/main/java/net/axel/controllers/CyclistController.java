package net.axel.controllers;

import net.axel.domains.dtos.cyclists.CyclistDto;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.domains.entities.Cyclist;
import net.axel.services.interfaces.ICyclistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(CyclistController.CONTROLLER_PATH)
public class CyclistController extends BaseController<Cyclist, CyclistDto, CyclistResponseDTO, UUID>{
    public final static String CONTROLLER_PATH = "/api/v1/cyclists";

    public CyclistController(ICyclistService cyclistService) {
        super(cyclistService);
    }
}
