package com.solutiscar.mapper.carro;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.carro.AcessorioDTO;
import com.solutiscar.model.entities.carro.Acessorio;

public interface AcessorioMapper extends MapperBase<Acessorio, AcessorioDTO> {

    @Override
    AcessorioDTO modelToDTO(Acessorio entity);

    @Override
    Acessorio dtoToModel(AcessorioDTO dto);
}

