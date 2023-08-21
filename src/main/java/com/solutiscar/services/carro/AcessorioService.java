package com.solutiscar.services.carro;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;

import com.solutiscar.mapper.carro.AcessorioMapper;
import com.solutiscar.model.dto.carro.AcessorioDTO;
import com.solutiscar.model.entities.carro.Acessorio;
import com.solutiscar.repositories.carro.AcessorioRepository;
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
public class AcessorioService extends ServiceCrud<AcessorioDTO> {

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private AcessorioMapper acessorioMapper;

    @Override
    public AcessorioDTO findById(Long id) {
        return this.acessorioMapper.modelToDTO(this.acessorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<AcessorioDTO> findAll() {
        List<Acessorio> list = this.acessorioRepository.findAll();
        return list.stream().map(this.acessorioMapper::modelToDTO).toList();
    }

    @Override
    public AcessorioDTO insert(AcessorioDTO dto) {
        Acessorio acessorioInsert = acessorioRepository.save(this.acessorioMapper.dtoToModel(dto));
        return this.acessorioMapper.modelToDTO(acessorioInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.acessorioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
