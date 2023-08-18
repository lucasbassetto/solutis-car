package com.solutiscar.services;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.CarroMapper;
import com.solutiscar.model.dto.CarroDTO;
import com.solutiscar.model.entities.Carro;
import com.solutiscar.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CarroService extends ServiceCrud<CarroDTO> {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroMapper carroMapper;

    @Override
    public CarroDTO findById(Long id) {
        return this.carroMapper.modelToDTO(this.carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<CarroDTO> findAll() {
        List<Carro> list = this.carroRepository.findAll();
        return list.stream().map(this.carroMapper::modelToDTO).toList();
    }

    @Override
    public CarroDTO insert(CarroDTO dto) {
        Carro carroInsert = carroRepository.save(this.carroMapper.dtoToModel(dto));
        return this.carroMapper.modelToDTO(carroInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.carroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
