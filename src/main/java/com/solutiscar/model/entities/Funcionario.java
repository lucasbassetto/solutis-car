package com.solutiscar.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {

    @NotBlank
    @Pattern(regexp = "\\d{5}")
    private String matricula;
}
