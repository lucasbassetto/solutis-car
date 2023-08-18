package com.solutiscar.mapper;

import com.solutiscar.model.dto.AluguelDTO;
import com.solutiscar.model.entities.Aluguel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapperIml implements AluguelMapper {

    @Override
    public AluguelDTO modelToDTO(Aluguel entity) {
        if ( entity == null ) {
            return null;
        }

        AluguelDTO aluguelDTO = new AluguelDTO();

        BeanUtils.copyProperties(entity, this);

        return aluguelDTO;
    }

    @Override
    public Aluguel dtoToModel(AluguelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluguel aluguelEntity = new Aluguel();

        BeanUtils.copyProperties(dto, this);

        return aluguelEntity;
    }
}
