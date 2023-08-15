package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Motorista;

public class MotoristaDTO extends PessoaDTO {

    private String numeroCNH;

    public MotoristaDTO() {

    }

    public MotoristaDTO(Motorista entity) {
        numeroCNH = entity.getNumeroCNH();
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
}
