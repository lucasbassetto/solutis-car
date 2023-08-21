package com.solutiscar.model.entities.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {

    @Column(unique = true, nullable = false)
    private String matricula;
}
