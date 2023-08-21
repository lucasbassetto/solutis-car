package com.solutiscar.mapper.carrinho;

import com.solutiscar.model.dto.carrinho.CarrinhoDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.carrinho.Carrinho;
;import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoIml implements CarrinhoMapper {


    @Override
    public CarrinhoDTO modelToDTO(Carrinho entity) {
        if (entity == null) {
            return null;
        }

        CarrinhoDTO carrinhoDTO = new CarrinhoDTO();

        carrinhoDTO.setId(entity.getId());
        carrinhoDTO.setMotoristaId(entity.getMotorista().getId());
        carrinhoDTO.setAlugueisId(entity.getAlugueis());

        return carrinhoDTO;
    }

    @Override
    public Carrinho dtoToModel(CarrinhoDTO dto) {
        if (dto == null) {
            return null;
        }

        Carrinho carrinhoEntity = new Carrinho();

        carrinhoEntity.setId(dto.getId());

        return carrinhoEntity;
    }

}
