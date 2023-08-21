package com.solutiscar.mapper.carro;

import com.solutiscar.model.dto.carro.FabricanteDTO;
import com.solutiscar.model.dto.carro.ModeloCarroDTO;
import com.solutiscar.model.entities.carro.Fabricante;
import com.solutiscar.model.entities.carro.ModeloCarro;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FabricanteMapperIml implements FabricanteMapper {


    @Override
    public FabricanteDTO modelToDTO(Fabricante entity) {
        if ( entity == null ) {
            return null;
        }

        FabricanteDTO fabricanteDTO = new FabricanteDTO();

        fabricanteDTO.setId(entity.getId());
        fabricanteDTO.setNome(entity.getNome());

        return fabricanteDTO;
    }

    @Override
    public Fabricante dtoToModel(FabricanteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Fabricante fabricanteEntity = new Fabricante();

        fabricanteEntity.setId(dto.getId());
        fabricanteEntity.setNome(dto.getNome());

        return fabricanteEntity;
    }
}
