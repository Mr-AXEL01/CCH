package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import net.axel.domains.dtos.cyclists.CyclistDto;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.Team;
import net.axel.mappers.CyclistMapper;
import net.axel.repositories.CyclistRepository;
import net.axel.repositories.TeamRepository;
import net.axel.services.interfaces.ICyclistService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class CyclistService extends BaseService<Cyclist, CyclistDto, CyclistResponseDTO, UUID> implements ICyclistService {

    private final TeamRepository teamRepository;

    public CyclistService(CyclistRepository cyclistRepository, CyclistMapper mapper, TeamRepository teamRepository ) {
        super(cyclistRepository, mapper);
        this.teamRepository = teamRepository;
    }

    @Override
    public CyclistResponseDTO create(CyclistDto dto) {
        Team team = teamRepository.findById(dto.teamId())
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + dto.teamId()));

        Cyclist cyclist = mapper.toEntity(dto)
                .setTeam(team);

        Cyclist savedCyclist = repository.save(cyclist);
        return mapper.toResponseDto(savedCyclist);
    }

    @Override
    protected void updateEntity(Cyclist cyclist, CyclistDto dto) {
        Team team = teamRepository.findById(dto.teamId())
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + dto.teamId()));

        cyclist.setFirstName(dto.firstName())
                .setLastName(dto.lastName())
                .setBirthdate(dto.birthdate())
                .setNationality(dto.nationality())
                .setTeam(team);
    }
}
