package com.solutiscar.services.carro;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.carro.FabricanteMapper;
import com.solutiscar.model.dto.carro.FabricanteDTO;
import com.solutiscar.model.entities.carro.Fabricante;
import com.solutiscar.repositories.carro.FabricanteRepository;
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
public class FabricanteService extends ServiceCrud<FabricanteDTO> {

    @Autowired
    private FabricanteRepository fabricanteReposiroy;

    @Autowired
    private FabricanteMapper fabricanteMapper;

    @Override
    public FabricanteDTO findById(Long id) {
        return this.fabricanteMapper.modelToDTO(this.fabricanteReposiroy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<FabricanteDTO> findAll() {
        List<Fabricante> list = this.fabricanteReposiroy.findAll();
        return list.stream().map(this.fabricanteMapper::modelToDTO).toList();
    }

    @Override
    public FabricanteDTO insert(FabricanteDTO dto) {
        Fabricante fabricanteInsert = fabricanteReposiroy.save(this.fabricanteMapper.dtoToModel(dto));
        return this.fabricanteMapper.modelToDTO(fabricanteInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.fabricanteReposiroy.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
