package com.solutiscar.mapper.carrinho;

import com.solutiscar.mapper.MapperBase;
import com.solutiscar.model.dto.carrinho.CarrinhoDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.carrinho.Carrinho;

public interface CarrinhoMapper extends MapperBase<Carrinho, CarrinhoDTO> {

    @Override
    CarrinhoDTO modelToDTO(Carrinho entity);

    @Override
    Carrinho dtoToModel(CarrinhoDTO dto);
}
