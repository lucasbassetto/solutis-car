package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Carro;
import com.solutiscar.model.entities.Fabricante;
import com.solutiscar.model.entities.enums.Categoria;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ModeloCarroDTO {

    private Long id;
    private String descricao;
    private Categoria categoria;
    private Fabricante fabricante;
    private Set<Carro> carros = new HashSet<>();
}

