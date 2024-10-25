package net.axel.services.interfaces;

import net.axel.domains.dtos.generalResults.GeneralResultDto;
import net.axel.domains.dtos.generalResults.GeneralResultResponseDTO;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.GeneralResult;

import java.util.List;

public interface IGeneralResultService extends IBaseService<GeneralResult, GeneralResultDto, GeneralResultResponseDTO, GeneralResultKey> {
}
