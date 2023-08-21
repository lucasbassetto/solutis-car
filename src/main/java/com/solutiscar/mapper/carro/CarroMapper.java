package com.solutiscar.mapper.carro;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.carro.CarroDTO;
import com.solutiscar.model.entities.carro.Carro;

public interface CarroMapper extends MapperBase<Carro, CarroDTO> {

    @Override
    CarroDTO modelToDTO(Carro entity);

    @Override
    Carro dtoToModel(CarroDTO dto);
}

