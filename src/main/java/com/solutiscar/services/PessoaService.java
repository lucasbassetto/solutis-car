package com.solutiscar.services;


import com.solutiscar.mapper.PessoaMapper;
import com.solutiscar.model.dto.PessoaDTO;
import com.solutiscar.model.entities.Pessoa;
import com.solutiscar.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService extends ServiceCrud<PessoaDTO>{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Override
    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa pessoaInsert = pessoaRepository.save(this.pessoaMapper.dtoToModel(dto));
        return this.pessoaMapper.modelToDTO(pessoaInsert);
    }

    @Override
    PessoaDTO obterPorId(Long id) {
        return null;
    }

    @Override
    List<PessoaDTO> listarTodos() {
        return null;
    }

    @Override
    void excluirPorId(Long id) {

    }
}
