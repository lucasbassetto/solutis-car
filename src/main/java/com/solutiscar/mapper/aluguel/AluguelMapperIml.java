package com.solutiscar.mapper.aluguel;

import com.solutiscar.model.dto.aluguel.AluguelDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.aluguel.ApoliceSeguro;
import com.solutiscar.model.entities.aluguel.Carrinho;
import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.pessoa.Motorista;
import com.solutiscar.repositories.aluguel.ApoliceSeguroRepository;
import com.solutiscar.repositories.carrinho.CarrinhoRepository;
import com.solutiscar.repositories.carro.CarroRepository;
import com.solutiscar.repositories.pessoa.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapperIml implements AluguelMapper {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarrinhoRepository carrinhoRepository;
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
//        aluguelDTO.setCarrinhoId(entity.getCarrinho().getId()); // Associando o ID do carrinho

        return aluguelDTO;
    }

    @Override
    public Aluguel dtoToModel(AluguelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluguel aluguelEntity = new Aluguel();

        if (dto.getId() != null) {
            aluguelEntity.setId(dto.getId().longValue());
        }

        aluguelEntity.setDataPedido(dto.getDataPedido());
        aluguelEntity.setDataEntrega(dto.getDataEntrega());
        aluguelEntity.setDataDevolucao(dto.getDataDevolucao());
        aluguelEntity.setValorTotal(dto.getValorTotal());

        if (dto.getApoliceSeguroId() != null) {
            ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(dto.getApoliceSeguroId())
                    .orElseThrow(() -> new RuntimeException("Apólice de seguro não encontrada: " + dto.getApoliceSeguroId()));
            aluguelEntity.setApoliceSeguro(apoliceSeguro);
        }

        if (dto.getMotoristaId() != null) {
            Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
                    .orElseThrow(() -> new RuntimeException("Motorista não encontrado: " + dto.getMotoristaId()));
            aluguelEntity.setMotorista(motorista);
        }

        if (dto.getCarroId() != null) {
            Carro carro = carroRepository.findById(dto.getCarroId())
                    .orElseThrow(() -> new RuntimeException("Carro não encontrado: " + dto.getCarroId()));
            aluguelEntity.setCarro(carro);
        }

        if (dto.getCarrinhoId() != null) {
            Carrinho carrinho = carrinhoRepository.findById(dto.getCarrinhoId())
                    .orElseThrow(() -> new RuntimeException("Carrinho não encontrado: " + dto.getCarrinhoId()));
            aluguelEntity.setCarrinho(carrinho);
        }

        return aluguelEntity;
    }
}
