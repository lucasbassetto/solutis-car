package com.solutiscar.mapper;

import com.solutiscar.model.dto.PessoaDTO;
import com.solutiscar.model.entities.Pessoa;


public interface PessoaMapper extends MapperBase<Pessoa, PessoaDTO> {

    @Override
    PessoaDTO modelToDTO(Pessoa entity);

    @Override
    Pessoa dtoToModel(PessoaDTO dto);
}
