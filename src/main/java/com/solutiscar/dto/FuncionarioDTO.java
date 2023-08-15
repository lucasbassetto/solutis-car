package com.solutiscar.dto;

import com.solutiscar.entities.Funcionario;
import com.solutiscar.entities.Pessoa;

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
