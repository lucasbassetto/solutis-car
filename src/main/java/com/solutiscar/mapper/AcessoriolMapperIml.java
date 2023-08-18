package com.solutiscar.mapper;

import com.solutiscar.model.dto.AcessorioDTO;
import com.solutiscar.model.entities.Acessorio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AcessoriolMapperIml implements AcessorioMapper {

    @Override
    public AcessorioDTO modelToDTO(Acessorio entity) {
        if ( entity == null ) {
            return null;
        }

        AcessorioDTO acessorioDTO = new AcessorioDTO();

        BeanUtils.copyProperties(entity, this);

        return acessorioDTO;
    }

    @Override
    public Acessorio dtoToModel(AcessorioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Acessorio acessorioEntity = new Acessorio();

        BeanUtils.copyProperties(dto, this);

        return acessorioEntity;
    }
}
