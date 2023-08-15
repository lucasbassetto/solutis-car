package com.solutiscar.services;


import com.solutiscar.dto.PessoaDTO;
import com.solutiscar.entities.Motorista;
import com.solutiscar.entities.Pessoa;
import com.solutiscar.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setDate(dto.getDate());
        pessoa.setCpf(dto.getCpf());

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        return convertEntityToDto(pessoaSalva);
    }

    private PessoaDTO convertEntityToDto(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getNome());
        dto.setDate(pessoa.getDate());
        return dto;
    }
}
