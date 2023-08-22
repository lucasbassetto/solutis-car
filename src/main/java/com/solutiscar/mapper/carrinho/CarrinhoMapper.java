package com.solutiscar.mapper.carrinho;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.aluguel.CarrinhoDTO;
import com.solutiscar.model.entities.aluguel.Carrinho;
import org.mapstruct.Mapper;

@Mapper
public interface CarrinhoMapper extends MapperBase<Carrinho, CarrinhoDTO> {

    @Override
    CarrinhoDTO modelToDTO(Carrinho entity);

    @Override
    Carrinho dtoToModel(CarrinhoDTO dto);
}
