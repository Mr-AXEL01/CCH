package net.axel.services.interfaces;

import net.axel.domains.dtos.CyclistDto;
import net.axel.domains.entities.Cyclist;

import java.util.List;
import java.util.UUID;

public interface ICyclistService {
    List<Cyclist> getAllCyclists();

    Cyclist getCyclistById(UUID id);

    Cyclist saveCyclist(CyclistDto dto);

    Cyclist updateCyclist(UUID id, CyclistDto dto);

    void deleteCyclist(UUID id);
}
