package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.TeamDto;
import net.axel.domains.entities.Team;
import net.axel.repositories.TeamRepository;
import net.axel.services.interfaces.ITeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService implements ITeamService {
    private final TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(UUID id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null); //TODO: handle optional result
    }

    @Override
    public Team saveTeam(TeamDto dto) {
        Team team = new Team(dto.teamName());
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(UUID id, TeamDto dto) {
        if (!teamRepository.existsById(id))
            throw new IllegalArgumentException("Team not found with ID :" + id);

        Team team = new Team(id, dto.teamName());
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(UUID id) {
        teamRepository.deleteById(id);
    }
}
