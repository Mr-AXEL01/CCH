package net.axel.controllers;

import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.services.interfaces.ICyclistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CyclistController.CONTROLLER_PATH)
@RequiredArgsConstructor
public class CyclistController {
    public final static String CONTROLLER_PATH = "/api/v1/cyclist";
    private final ICyclistService cyclistService;

    @GetMapping
    public ResponseEntity<List<CyclistResponseDTO>> getAllCyclists() {
        List<CyclistResponseDTO> cyclists = cyclistService.getAllCyclists();
        return ResponseEntity.ok(cyclists);
    }
}
