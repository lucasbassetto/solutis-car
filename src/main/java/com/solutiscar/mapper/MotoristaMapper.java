package com.solutiscar.mapper;

import com.solutiscar.model.dto.MotoristaDTO;
import com.solutiscar.model.dto.PessoaDTO;
import com.solutiscar.model.entities.Motorista;
import com.solutiscar.model.entities.Pessoa;
import org.mapstruct.Mapper;

@Mapper
public interface MotoristaMapper extends MapperBase<Motorista, MotoristaDTO> {

    @Override
    MotoristaDTO modelToDTO(Motorista entity);

    @Override
    Motorista dtoToModel(MotoristaDTO dto);
}
