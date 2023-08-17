package com.solutiscar.services;


import com.solutiscar.mapper.PessoaMapper;
import com.solutiscar.model.dto.PessoaDTO;
import com.solutiscar.model.entities.Pessoa;
import com.solutiscar.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PessoaService extends ServiceCrud<PessoaDTO>{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;


    @Override
    public PessoaDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PessoaDTO> findAll() {
        return null;
    }

    @Override
    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa pessoaInsert = pessoaRepository.save(this.pessoaMapper.dtoToModel(dto));
        return this.pessoaMapper.modelToDTO(pessoaInsert);
    }

    @Override
    public void deleteById(Long id) {

    }

}
