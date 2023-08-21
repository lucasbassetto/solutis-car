package com.solutiscar.mapper.carro;

import com.solutiscar.model.dto.carro.AcessorioDTO;
import com.solutiscar.model.dto.carro.CarroDTO;
import com.solutiscar.model.entities.carro.Acessorio;
import com.solutiscar.model.entities.carro.Carro;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AcessorioMapperIml implements AcessorioMapper {


    @Override
    public AcessorioDTO modelToDTO(Acessorio entity) {
        if (entity == null) {
            return null;
        }

        AcessorioDTO acessorioDTO = new AcessorioDTO();

        acessorioDTO.setId(entity.getId());
        acessorioDTO.setDescricao(entity.getDescricao());

        return acessorioDTO;
    }

    @Override
    public Acessorio dtoToModel(AcessorioDTO dto) {
        if (dto == null) {
            return null;
        }

        Acessorio acessorioEntity = new Acessorio();

        acessorioEntity.setId(dto.getId());
        acessorioEntity.setDescricao(dto.getDescricao());

        return acessorioEntity;
    }
}

