package com.solutiscar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

    private String numeroCNH;

    public Motorista() {
    }

    public Motorista(Long id, String nome, Instant date, String cpf, String numeroCNH) {
        super(id, nome, date, cpf);
        this.numeroCNH = numeroCNH;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }


}
