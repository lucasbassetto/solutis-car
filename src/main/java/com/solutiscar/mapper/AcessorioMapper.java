package com.solutiscar.mapper;

import com.solutiscar.model.dto.AcessorioDTO;
import com.solutiscar.model.entities.Acessorio;

public interface AcessorioMapper extends MapperBase<Acessorio, AcessorioDTO> {

    @Override
    AcessorioDTO modelToDTO(Acessorio entity);

    @Override
    Acessorio dtoToModel(AcessorioDTO dto);
}
