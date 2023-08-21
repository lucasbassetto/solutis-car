package com.solutiscar.model.dto.carro;

import com.solutiscar.model.entities.carro.Fabricante;
import com.solutiscar.model.entities.enums.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class ModeloCarroDTO {

    private Long id;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description is required")
    @Size(min = 1, max = 255, message = "Description must be between 1 and 255 characters long")
    private String descricao;

    @NotNull(message = "Category is required")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @NotNull(message = "Manufacturer is required")
    private Long fabricanteId;
}

