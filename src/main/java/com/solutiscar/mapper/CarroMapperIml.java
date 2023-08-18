package com.solutiscar.mapper;

import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.model.entities.Carro;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CarroMapperIml implements CarroMapper {

    @Override
    public CarroDTO modelToDTO(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();

        BeanUtils.copyProperties(entity, this);

        return carroDTO;
    }

    @Override
    public Carro dtoToModel(CarroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Carro carroEntity = new Carro();

        BeanUtils.copyProperties(dto, this);

        return carroEntity;
    }
}
