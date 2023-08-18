package com.solutiscar.mapper;

import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.model.dto.MotoristaDTO;
import com.solutiscar.model.entities.Carro;
import com.solutiscar.model.entities.Motorista;

public interface CarroMapper extends MapperBase<Carro, CarroDTO> {

    @Override
    CarroDTO modelToDTO(Carro entity);

    @Override
    Carro dtoToModel(CarroDTO dto);
}

