package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Carro;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class AcessorioDTO {

    private Long id;
    private String descricao;
    private Set<Carro> carros = new HashSet<>();
}
