package com.solutiscar.mapper.aluguel;

import com.solutiscar.model.dto.aluguel.AluguelDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
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

        aluguelDTO.setId(entity.getId());
        aluguelDTO.setDataPedido(entity.getDataPedido());
        aluguelDTO.setDataEntrega(entity.getDataEntrega());
        aluguelDTO.setDataDevolucao(entity.getDataDevolucao());
        aluguelDTO.setValorTotal(entity.getValorTotal());
        aluguelDTO.setApoliceSeguroId(entity.getApoliceSeguro().getId()); // Associando o ID da apólice de seguro
        aluguelDTO.setMotoristaId(entity.getMotorista().getId()); // Associando o ID do motorista
        aluguelDTO.setCarroId(entity.getCarro().getId()); // Associando o ID do carro
        aluguelDTO.setCarrinhotId(entity.getCarrinho().getId()); // Associando o ID do carrinho

        return aluguelDTO;
    }

    @Override
    public Aluguel dtoToModel(AluguelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluguel aluguelEntity = new Aluguel();

        aluguelEntity.setId(dto.getId());
        aluguelEntity.setDataPedido(dto.getDataPedido());
        aluguelEntity.setDataEntrega(dto.getDataEntrega());
        aluguelEntity.setDataDevolucao(dto.getDataDevolucao());
        aluguelEntity.setValorTotal(dto.getValorTotal());

        return aluguelEntity;
    }
}
