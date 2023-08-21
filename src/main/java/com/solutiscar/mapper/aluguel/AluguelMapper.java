package com.solutiscar.mapper.aluguel;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.aluguel.AluguelDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
public interface AluguelMapper extends MapperBase<Aluguel, AluguelDTO> {

    @Override
    AluguelDTO modelToDTO(Aluguel entity);

    @Override
    Aluguel dtoToModel(AluguelDTO dto);
}
