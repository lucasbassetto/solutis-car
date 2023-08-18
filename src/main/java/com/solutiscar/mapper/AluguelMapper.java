package com.solutiscar.mapper;

import com.solutiscar.model.dto.AluguelDTO;
import com.solutiscar.model.entities.Aluguel;
public interface AluguelMapper extends MapperBase<Aluguel, AluguelDTO> {

    @Override
    AluguelDTO modelToDTO(Aluguel entity);

    @Override
    Aluguel dtoToModel(AluguelDTO dto);
}
