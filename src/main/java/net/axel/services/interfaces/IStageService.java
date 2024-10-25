package net.axel.services.interfaces;

import net.axel.domains.dtos.stages.StageDto;
import net.axel.domains.dtos.stages.StageResponseDTO;
import net.axel.domains.entities.Stage;

import java.util.List;
import java.util.UUID;

public interface IStageService extends IBaseService<Stage, StageDto, StageResponseDTO, UUID> {
}
