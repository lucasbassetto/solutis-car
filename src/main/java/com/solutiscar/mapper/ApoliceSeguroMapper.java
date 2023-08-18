package com.solutiscar.mapper;

import com.solutiscar.model.dto.ApoliceSeguroDTO;
import com.solutiscar.model.entities.ApoliceSeguro;

public interface ApoliceSeguroMapper extends MapperBase<ApoliceSeguro, ApoliceSeguroDTO> {

    @Override
    ApoliceSeguroDTO modelToDTO(ApoliceSeguro entity);

    @Override
    ApoliceSeguro dtoToModel(ApoliceSeguroDTO dto);
}
