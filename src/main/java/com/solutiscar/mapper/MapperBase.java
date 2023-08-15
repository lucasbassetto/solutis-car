package com.solutiscar.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface MapperBase<E, D> {
    @Mapping(target = ".", source = ".", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        D modelToDTO(E entity);

    @Mapping(target = ".", source = ".", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E dtoToModel(D dto);
}