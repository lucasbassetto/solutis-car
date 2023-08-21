package com.solutiscar.mapper.carro;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.carro.ModeloCarroDTO;
import com.solutiscar.model.entities.carro.ModeloCarro;

public interface ModeloCarroMapper extends MapperBase<ModeloCarro, ModeloCarroDTO> {

    @Override
    ModeloCarroDTO modelToDTO(ModeloCarro entity);

    @Override
    ModeloCarro dtoToModel(ModeloCarroDTO dto);
}
