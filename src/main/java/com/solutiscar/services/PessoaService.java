package com.solutiscar.services;

import com.solutiscar.entities.Pessoa;
import com.solutiscar.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
