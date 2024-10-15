package net.axel.services.interfaces;

import net.axel.domains.entities.Cyclist;

import java.util.List;
import java.util.UUID;

public interface ICyclistService {
    List<Cyclist> getAllCyclists();

    Cyclist getCyclistById(UUID id);

    Cyclist saveCyclist(Cyclist cyclist);

    void deleteCyclist(UUID id);
}
