package com.solutiscar.services.carro;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.carro.CarroMapper;
import com.solutiscar.mapper.carro.ModeloCarroMapper;
import com.solutiscar.model.dto.carro.ModeloCarroDTO;
import com.solutiscar.model.dto.carro.ModeloCarroDTO;
import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.carro.ModeloCarro;
import com.solutiscar.repositories.carro.CarroRepository;
import com.solutiscar.repositories.carro.ModeloCarroRepository;
import com.solutiscar.services.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ModeloCarroService extends ServiceCrud<ModeloCarroDTO> {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private ModeloCarroMapper modeloCarroMapper;

    @Override
    public ModeloCarroDTO findById(Long id) {
        return this.modeloCarroMapper.modelToDTO(this.modeloCarroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<ModeloCarroDTO> findAll() {
        List<ModeloCarro> list = this.modeloCarroRepository.findAll();
        return list.stream().map(this.modeloCarroMapper::modelToDTO).toList();
    }

    @Override
    public ModeloCarroDTO insert(ModeloCarroDTO dto) {
        ModeloCarro modeloCarroInsert = modeloCarroRepository.save(this.modeloCarroMapper.dtoToModel(dto));
        return this.modeloCarroMapper.modelToDTO(modeloCarroInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.modeloCarroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
