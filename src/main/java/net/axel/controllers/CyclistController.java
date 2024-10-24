package net.axel.controllers;

import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.cyclists.CyclistDto;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.services.interfaces.ICyclistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(CyclistController.CONTROLLER_PATH)
@RequiredArgsConstructor
public class CyclistController {
    public final static String CONTROLLER_PATH = "/api/v1/cyclists";
    private final ICyclistService cyclistService;

    @GetMapping
    public ResponseEntity<List<CyclistResponseDTO>> getAllCyclists() {
        List<CyclistResponseDTO> cyclists = cyclistService.getAllCyclists();
        return ResponseEntity.ok(cyclists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> getCyclistById(@PathVariable("id") UUID id) {
        CyclistResponseDTO cyclist = cyclistService.getCyclistById(id);
        return ResponseEntity.ok(cyclist);
    }
    
    @PostMapping
    public ResponseEntity<CyclistResponseDTO> createCyclist(@RequestBody CyclistDto dto) {
        CyclistResponseDTO createdCyclist = cyclistService.saveCyclist(dto);
        return new ResponseEntity<>(createdCyclist, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CyclistResponseDTO> updateCyclist(@PathVariable("id") UUID id, @RequestBody CyclistDto dto) {
        CyclistResponseDTO updatedCyclist = cyclistService.updateCyclist(id, dto);
        return ResponseEntity.ok(updatedCyclist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCyclist(@PathVariable("id") UUID id) {
        cyclistService.deleteCyclist(id);
        return ResponseEntity.noContent().build();
    }
}
