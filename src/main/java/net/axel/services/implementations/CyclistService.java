package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import net.axel.domains.entities.Cyclist;
import net.axel.repositories.CyclistRepository;
import net.axel.services.interfaces.ICyclistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CyclistService implements ICyclistService {

    private final CyclistRepository cyclistRepository;

    public CyclistService(CyclistRepository cyclistRepository) {
        this.cyclistRepository = cyclistRepository;
    }

    public List<Cyclist> getAllCyclists() {
        return cyclistRepository.findAll();
    }

    public Cyclist getCyclistById(UUID id) {
        return cyclistRepository.findById(id).orElse(null);
    }

    public Cyclist saveCyclist(Cyclist cyclist) {
        return cyclistRepository.save(cyclist);
    }

    public void deleteCyclist(UUID id) {
        cyclistRepository.deleteById(id);
    }
}
