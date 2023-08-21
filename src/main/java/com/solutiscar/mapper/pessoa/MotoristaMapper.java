package com.solutiscar.mapper.pessoa;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.pessoa.MotoristaDTO;
import com.solutiscar.model.entities.pessoa.Motorista;
import org.mapstruct.Mapper;

@Mapper
public interface MotoristaMapper extends MapperBase<Motorista, MotoristaDTO> {

    @Override
    MotoristaDTO modelToDTO(Motorista entity);

    @Override
    Motorista dtoToModel(MotoristaDTO dto);
}
