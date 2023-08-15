package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Funcionario;

public class FuncionarioDTO extends PessoaDTO {

    private String matricula;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario entity) {
        matricula = entity.getMatricula();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
