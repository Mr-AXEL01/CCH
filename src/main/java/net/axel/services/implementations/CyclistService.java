package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.CyclistDto;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.Team;
import net.axel.repositories.CyclistRepository;
import net.axel.services.interfaces.ICyclistService;
import net.axel.services.interfaces.ITeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CyclistService implements ICyclistService {

    private final CyclistRepository cyclistRepository;
    private final ITeamService teamService;

    @Override
    public List<Cyclist> getAllCyclists() {
        return cyclistRepository.findAll();
    }

    @Override
    public Cyclist getCyclistById(UUID id) {
        return cyclistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cyclist not found with id :" + id));
    }

    @Override
    public Cyclist saveCyclist(CyclistDto dto) {
        Team team = teamService.getTeamById(dto.teamId());
        Cyclist cyclist = new Cyclist(dto.firstName(), dto.lastName(), dto.birthdate(), dto.nationality(), team);
        return cyclistRepository.save(cyclist);
    }

    @Override
    public Cyclist updateCyclist(UUID id, CyclistDto dto) {
        Team team = teamService.getTeamById(dto.teamId());

        Cyclist cyclist = getCyclistById(id);
        cyclist.setFirstName(dto.firstName())
                .setLastName(dto.lastName())
                .setBirthdate(dto.birthdate())
                .setNationality(dto.nationality())
                .setTeam(team);

        return cyclistRepository.save(cyclist);
    }

    @Override
    public void deleteCyclist(UUID id) {
        cyclistRepository.deleteById(id);
    }
}
