package com.solutiscar.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutiscar.model.entities.enums.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_modelo")
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    @NotNull
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @JsonIgnore
    @OneToMany(mappedBy = "modeloCarro")
    private Set<Carro> carros = new HashSet<>();
}
