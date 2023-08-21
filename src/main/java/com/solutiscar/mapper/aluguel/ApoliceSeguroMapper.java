package com.solutiscar.mapper.aluguel;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.aluguel.AluguelDTO;
import com.solutiscar.model.dto.aluguel.ApoliceSeguroDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.aluguel.ApoliceSeguro;

public interface ApoliceSeguroMapper extends MapperBase<ApoliceSeguro, ApoliceSeguroDTO> {

    @Override
    ApoliceSeguroDTO modelToDTO(ApoliceSeguro entity);

    @Override
    ApoliceSeguro dtoToModel(ApoliceSeguroDTO dto);
}
