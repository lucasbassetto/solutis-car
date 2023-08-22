package com.solutiscar.mapper.carrinho;

import com.solutiscar.model.dto.aluguel.CarrinhoDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.aluguel.Carrinho;
import com.solutiscar.model.entities.carro.Acessorio;
import com.solutiscar.model.entities.carro.ModeloCarro;
import com.solutiscar.model.entities.pessoa.Motorista;
import com.solutiscar.repositories.aluguel.AluguelRepository;
import com.solutiscar.repositories.pessoa.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
;import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarrinhoIml implements CarrinhoMapper {


    @Autowired
    private MotoristaRepository motoristaRepository; // Suponha que você tenha um repositório para motoristas

    @Autowired
    private AluguelRepository aluguelRepository;
    @Override
    public CarrinhoDTO modelToDTO(Carrinho entity) {
        if (entity == null) {
            return null;
        }

        CarrinhoDTO carrinhoDTO = new CarrinhoDTO();

        carrinhoDTO.setId(entity.getId());
        carrinhoDTO.setMotoristaId(entity.getMotorista().getId());

        List<Long> alugueisId = entity.getAlugueis().stream()
                .map(Aluguel::getId) // Suponha que sua classe Aluguel tenha um método getId()
                .collect(Collectors.toList());
        carrinhoDTO.setAlugueisId(alugueisId);

        return carrinhoDTO;
    }

    @Override
    public Carrinho dtoToModel(CarrinhoDTO dto) {
        if (dto == null) {
            return null;
        }

        Carrinho carrinhoEntity = new Carrinho();

        carrinhoEntity.setId(dto.getId());


        if (dto.getMotoristaId() != null) {
            Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
                    .orElseThrow(() -> new RuntimeException("Motorista não encontrado: " + dto.getMotoristaId()));
            carrinhoEntity.setMotorista(motorista);
        }

        if (dto.getAlugueisId() != null) {
            List<Aluguel> alugueis = aluguelRepository.findAllById(dto.getAlugueisId());
            carrinhoEntity.setAlugueis(new ArrayList<>(alugueis));
        }
        return carrinhoEntity;
    }
}
