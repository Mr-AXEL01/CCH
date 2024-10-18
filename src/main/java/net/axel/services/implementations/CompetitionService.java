package net.axel.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.domains.dtos.CompetitionDto;
import net.axel.domains.entities.Competition;
import net.axel.repositories.CompetitionRepository;
import net.axel.services.interfaces.ICompetitionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CompetitionService implements ICompetitionService {

    private final CompetitionRepository competitionRepository;

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition getCompetitionById(UUID id) {
        return null;
    }

    @Override
    public Competition saveCompetition(CompetitionDto dto) {
        return null;
    }

    @Override
    public Competition updateCompetition(UUID id, CompetitionDto dto) {
        return null;
    }

    @Override
    public void deleteCompetition(UUID id) {

    }
}
