package com.solutiscar.mapper;

import com.solutiscar.model.dto.PessoaDTO;
import com.solutiscar.model.entities.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapperIml implements PessoaMapper {

    @Override
    public PessoaDTO modelToDTO(Pessoa entity) {
        if ( entity == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setNome(entity.getNome());
        pessoaDTO.setDate(entity.getDate());
        pessoaDTO.setCpf(entity.getCpf());
        pessoaDTO.setSexo(entity.getSexo());

        return pessoaDTO;
    }

    @Override
    public Pessoa dtoToModel(PessoaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pessoa pessoaEntity = new Pessoa();

        pessoaEntity.setNome(dto.getNome());
        pessoaEntity.setDate(dto.getDate());
        pessoaEntity.setCpf(dto.getCpf());
        pessoaEntity.setSexo(dto.getSexo());

        return pessoaEntity;
    }
}
