package net.axel.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseMapper<E, R, D> {

    E toEntity(D dto);

    R toResponseDto(E entity);
}
