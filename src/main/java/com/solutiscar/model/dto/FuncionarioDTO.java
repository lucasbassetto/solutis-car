package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Funcionario;
import org.springframework.beans.BeanUtils;

public class FuncionarioDTO extends PessoaDTO {

    private String matricula;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
