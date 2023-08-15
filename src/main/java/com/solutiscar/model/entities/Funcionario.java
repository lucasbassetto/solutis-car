package com.solutiscar.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {

    private String matricula;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, Instant date, String cpf, String matricula) {
        super(id, nome, date, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
