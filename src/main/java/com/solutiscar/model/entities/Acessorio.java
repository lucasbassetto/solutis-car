package com.solutiscar.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "tb_acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

//    @JsonIgnore
    @ManyToMany(mappedBy = "acessorios")
    private Set<Carro> carros = new HashSet<>();
}
