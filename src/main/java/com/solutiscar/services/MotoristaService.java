package com.solutiscar.services;


import com.solutiscar.exception.DashNotFoundException;
import com.solutiscar.mapper.MotoristaMapper;
import com.solutiscar.model.dto.MotoristaDTO;
import com.solutiscar.model.entities.Motorista;
import com.solutiscar.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MotoristaService extends ServiceCrud<MotoristaDTO> {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private MotoristaMapper motoristaMapper;

    @Override
    public MotoristaDTO findById(Long id) {
        return this.motoristaMapper.modelToDTO(this.motoristaRepository.findById(id)
                .orElseThrow(DashNotFoundException::new));
    }

    @Override
    public List<MotoristaDTO> findAll() {
        List<Motorista> colaboradores = this.motoristaRepository.findAll();
        return colaboradores.stream().map(this.motoristaMapper::modelToDTO).toList();
    }

    @Override
    public MotoristaDTO insert(MotoristaDTO dto) {
        Motorista motoristaInsert = motoristaRepository.save(this.motoristaMapper.dtoToModel(dto));
        return this.motoristaMapper.modelToDTO(motoristaInsert);
    }

    @Override
    public void deleteById(Long id) {
        this.motoristaRepository.deleteById(id);
    }
}
