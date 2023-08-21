package com.solutiscar.services.aluguel;

import com.solutiscar.exception.DatabaseException;
import com.solutiscar.exception.ResourceNotFoundException;
import com.solutiscar.mapper.aluguel.ApoliceSeguroMapper;
import com.solutiscar.model.dto.aluguel.ApoliceSeguroDTO;
import com.solutiscar.model.entities.aluguel.ApoliceSeguro;
import com.solutiscar.repositories.aluguel.ApoliceSeguroRepository;
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
public class ApoliceSeguroService extends ServiceCrud<ApoliceSeguroDTO> {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Autowired
    private ApoliceSeguroMapper apoliceSeguroMapper;

    @Override
    public ApoliceSeguroDTO findById(Long id) {
        return this.apoliceSeguroMapper.modelToDTO(this.apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<ApoliceSeguroDTO> findAll() {
        List<ApoliceSeguro> list = this.apoliceSeguroRepository.findAll();
        return list.stream().map(this.apoliceSeguroMapper::modelToDTO).toList();
    }

    @Override
    public ApoliceSeguroDTO insert(ApoliceSeguroDTO dto) {
        ApoliceSeguro apoliceSeguroInsert = apoliceSeguroRepository.save(this.apoliceSeguroMapper.dtoToModel(dto));
        return this.apoliceSeguroMapper.modelToDTO(apoliceSeguroInsert);
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.apoliceSeguroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
