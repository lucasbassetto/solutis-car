package com.solutiscar.mapper;

import com.solutiscar.model.dto.MotoristaDTO;
import com.solutiscar.model.dto.PessoaDTO;
import com.solutiscar.model.entities.Motorista;
import com.solutiscar.model.entities.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapperIml implements MotoristaMapper {

    @Override
    public MotoristaDTO modelToDTO(Motorista entity) {
        if ( entity == null ) {
            return null;
        }

        MotoristaDTO motoristaDTO = new MotoristaDTO();

        motoristaDTO.setId(entity.getId());
        motoristaDTO.setNome(entity.getNome());
        motoristaDTO.setDate(entity.getDate());
        motoristaDTO.setCpf(entity.getCpf());
        motoristaDTO.setSexo(entity.getSexo());
        motoristaDTO.setNumeroCNH(entity.getNumeroCNH());

        return motoristaDTO;
    }

    @Override
    public Motorista dtoToModel(MotoristaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Motorista motoristaEntity = new Motorista();

        motoristaEntity.setId(dto.getId());
        motoristaEntity.setNome(dto.getNome());
        motoristaEntity.setDate(dto.getDate());
        motoristaEntity.setCpf(dto.getCpf());
        motoristaEntity.setSexo(dto.getSexo());
        motoristaEntity.setNumeroCNH(dto.getNumeroCNH());

        return motoristaEntity;
    }
}
