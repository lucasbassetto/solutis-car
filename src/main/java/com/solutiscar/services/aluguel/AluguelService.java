package com.solutiscar.services.aluguel;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.aluguel.AluguelMapper;
import com.solutiscar.model.dto.aluguel.AluguelDTO;
import com.solutiscar.model.dto.aluguel.ApoliceSeguroDTO;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.aluguel.ApoliceSeguro;
import com.solutiscar.repositories.aluguel.AluguelRepository;
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
public class AluguelService extends ServiceCrud<AluguelDTO> {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private AluguelMapper aluguelMapper;

    @Override
    public AluguelDTO findById(Long id) {
        return this.aluguelMapper.modelToDTO(this.aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<AluguelDTO> findAll() {
        List<Aluguel> list = this.aluguelRepository.findAll();
        return list.stream().map(this.aluguelMapper::modelToDTO).toList();
    }

    @Override
    public AluguelDTO insert(AluguelDTO dto) {
        Aluguel aluguelInsert = aluguelRepository.save(this.aluguelMapper.dtoToModel(dto));
        return this.aluguelMapper.modelToDTO(aluguelInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.aluguelRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public AluguelDTO update(AluguelDTO dto) {
        Aluguel aluguelExistente = aluguelRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado: " + dto.getId()));

        aluguelExistente.setDataPedido(dto.getDataPedido());
        aluguelExistente.setDataEntrega(dto.getDataEntrega());
        aluguelExistente.setDataDevolucao(dto.getDataDevolucao());
        aluguelExistente.setValorTotal(dto.getValorTotal());

        Aluguel aluguelAtualizado = aluguelRepository.save(aluguelExistente);

        return aluguelMapper.modelToDTO(aluguelAtualizado);
    }
}
