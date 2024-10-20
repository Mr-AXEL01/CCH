package net.axel.services.interfaces;

import net.axel.domains.dtos.GeneralResultDto;
import net.axel.domains.embeddeds.GeneralResultKey;
import net.axel.domains.entities.GeneralResult;

import java.util.List;
import java.util.UUID;

public interface IGeneralResultService {
    List<GeneralResult> getAllGeneralResults();

    GeneralResult getGeneralResultById(GeneralResultKey id);

    GeneralResult saveGeneralResult(GeneralResultDto dto);

    GeneralResult updateGeneralResult(GeneralResultKey id, GeneralResultDto dto);

    void deleteGeneralResult(GeneralResultKey id);
}
