package com.solutiscar.mapper;

import com.solutiscar.model.dto.ApoliceSeguroDTO;
import com.solutiscar.model.entities.ApoliceSeguro;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ApoliceSegurolMapperIml implements ApoliceSeguroMapper {

    @Override
    public ApoliceSeguroDTO modelToDTO(ApoliceSeguro entity) {
        if ( entity == null ) {
            return null;
        }

        ApoliceSeguroDTO apoliceSeguroDTO = new ApoliceSeguroDTO();

        BeanUtils.copyProperties(entity, this);

        return apoliceSeguroDTO;
    }

    @Override
    public ApoliceSeguro dtoToModel(ApoliceSeguroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ApoliceSeguro apoliceSeguroEntity = new ApoliceSeguro();

        BeanUtils.copyProperties(dto, this);

        return apoliceSeguroEntity;
    }
}
