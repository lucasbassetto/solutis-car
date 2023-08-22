package com.solutiscar.services.aluguel;


import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.carrinho.CarrinhoMapper;
import com.solutiscar.model.dto.aluguel.CarrinhoDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.aluguel.Carrinho;
import com.solutiscar.model.entities.pessoa.Motorista;
import com.solutiscar.repositories.aluguel.AluguelRepository;
import com.solutiscar.repositories.carrinho.CarrinhoRepository;
import com.solutiscar.repositories.pessoa.MotoristaRepository;
import com.solutiscar.services.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CarrinhoService extends ServiceCrud<CarrinhoDTO> {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarrinhoMapper carrinhoMapper;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public CarrinhoDTO findById(Long id) {
        return this.carrinhoMapper.modelToDTO(this.carrinhoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<CarrinhoDTO> findAll() {
        List<Carrinho> list = this.carrinhoRepository.findAll();
        return list.stream().map(this.carrinhoMapper::modelToDTO).toList();
    }

    @Override
    public CarrinhoDTO insert(CarrinhoDTO dto) {
        Carrinho aluguelInsert = carrinhoRepository.save(this.carrinhoMapper.dtoToModel(dto));
        return this.carrinhoMapper.modelToDTO(aluguelInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.carrinhoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public CarrinhoDTO update(CarrinhoDTO payload) {
        Carrinho carrinhoExistente = carrinhoRepository.findById(payload.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado: " + payload.getId()));

        Motorista motorista = motoristaRepository.findById(payload.getMotoristaId())
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado: " + payload.getMotoristaId()));

        carrinhoExistente.setMotorista(motorista);

        List<Long> alugueisId = payload.getAlugueisId();
        if (alugueisId != null && !alugueisId.isEmpty()) {
            List<Aluguel> alugueis = aluguelRepository.findAllById(alugueisId);
            carrinhoExistente.setAlugueis(alugueis);
        } else {
            carrinhoExistente.getAlugueis().clear();
        }

        Carrinho carrinhoAtualizado = carrinhoRepository.save(carrinhoExistente);
        return carrinhoMapper.modelToDTO(carrinhoAtualizado);
    }
}
