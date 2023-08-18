package com.solutiscar.model.dto;


import com.solutiscar.model.entities.ModeloCarro;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FabricanteDTO {

    private Long id;
    private String nome;
    private List<ModeloCarro> modelos = new ArrayList<>();
}

