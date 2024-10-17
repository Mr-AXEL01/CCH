package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        if (teamRepository.existsById(team.getId())) {
            return teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Team not found with ID :" + team.getId());
        }
    }

    @Override
    public void deleteTeam(UUID id) {
        teamRepository.deleteById(id);
    }
}
