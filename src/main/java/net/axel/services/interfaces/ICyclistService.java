package net.axel.services.interfaces;

import net.axel.domains.dtos.cyclists.CyclistDto;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.domains.entities.Cyclist;

import java.util.List;
import java.util.UUID;

public interface ICyclistService {
    List<CyclistResponseDTO> getAllCyclists();

    CyclistResponseDTO getCyclistById(UUID id);

    CyclistResponseDTO saveCyclist(CyclistDto dto);

    CyclistResponseDTO updateCyclist(UUID id, CyclistDto dto);

    void deleteCyclist(UUID id);
}
