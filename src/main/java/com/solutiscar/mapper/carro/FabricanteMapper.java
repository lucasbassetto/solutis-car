package com.solutiscar.mapper.carro;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.carro.FabricanteDTO;
import com.solutiscar.model.entities.carro.Fabricante;

public interface FabricanteMapper extends MapperBase<Fabricante, FabricanteDTO> {

    @Override
    FabricanteDTO modelToDTO(Fabricante entity);

    @Override
    Fabricante dtoToModel(FabricanteDTO dto);
}
