package com.solutiscar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solutiscar.entities.Pessoa;
import org.springframework.beans.BeanUtils;

import java.time.Instant;

public class PessoaDTO {

    private Long id;
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;
    private String cpf;

    public PessoaDTO() {

    }

    public PessoaDTO(Pessoa entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
