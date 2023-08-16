package com.solutiscar.model.entities;

import com.solutiscar.model.entities.enums.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]+")
    private String numeroCNH;

    public Motorista() {
    }

    public Motorista(Long id, String nome, Instant date, String cpf, Sexo sexo, String numeroCNH) {
        super(id, nome, date, cpf, sexo);
        this.numeroCNH = numeroCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
}
