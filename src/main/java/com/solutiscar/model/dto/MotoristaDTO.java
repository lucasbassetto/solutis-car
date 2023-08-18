package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Aluguel;
import com.solutiscar.model.entities.Motorista;

import java.util.ArrayList;
import java.util.List;

public class MotoristaDTO extends PessoaDTO {

    private String numeroCNH;

    private List<Aluguel> alugueis = new ArrayList<>();
    public MotoristaDTO() {

    }

    public MotoristaDTO(Motorista entity) {
        numeroCNH = entity.getNumeroCNH();
        alugueis = entity.getAlugueis();
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
}
