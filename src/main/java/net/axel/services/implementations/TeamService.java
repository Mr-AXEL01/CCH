package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Team;
import net.axel.mappers.TeamMapper;
import net.axel.repositories.TeamRepository;
import net.axel.services.interfaces.ITeamService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class TeamService extends BaseService<Team, TeamDto, TeamResponseDTO, UUID> implements ITeamService {

    public TeamService(TeamRepository teamRepository, TeamMapper mapper) {
        super(teamRepository, mapper);
    }

    @Override
    protected void updateEntity(Team team, TeamDto dto) {
        team.setName(dto.name());
    }
}
