package net.axel.services.interfaces;

import net.axel.domains.dtos.cyclists.CyclistDto;
import net.axel.domains.dtos.cyclists.CyclistResponseDTO;
import net.axel.domains.dtos.teams.TeamDto;
import net.axel.domains.dtos.teams.TeamResponseDTO;
import net.axel.domains.entities.Cyclist;
import net.axel.domains.entities.Team;

import java.util.List;
import java.util.UUID;

public interface ICyclistService extends IBaseService<Cyclist, CyclistDto, CyclistResponseDTO, UUID> {
}
