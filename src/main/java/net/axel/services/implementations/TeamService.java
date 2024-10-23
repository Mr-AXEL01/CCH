package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Team;
import net.axel.mapper.TeamMapper;
import net.axel.repositories.TeamRepository;
import net.axel.services.interfaces.ITeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService implements ITeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper mapper;

    @Override
    public List<TeamResponseDTO> getAllTeams() {
        return teamRepository.findAll()
                .stream().map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public TeamResponseDTO getTeamById(UUID id) {
        return teamRepository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));
    }

    @Override
    public TeamResponseDTO saveTeam(TeamDto dto) {
        Team team = mapper.toEntity(dto);
        Team savedTeam = teamRepository.save(team);
        return mapper.toResponseDto(savedTeam);
    }

    @Override
    public TeamResponseDTO updateTeam(UUID id, TeamDto dto) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));

        team.setName(dto.name());

        Team updatedTeam = teamRepository.save(team);

        return mapper.toResponseDto(updatedTeam);
    }

    @Override
    public void deleteTeam(UUID id) {
        teamRepository.deleteById(id);
    }
}
