package net.axel.mapper;

public interface BaseMapper<E, R, D> {

    E toEntity(D dto);

    R toResponseDto(E entity);
}
