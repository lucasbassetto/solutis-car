package com.solutiscar.model.dto.pessoa;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.solutiscar.model.entities.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class MotoristaDTO {

    private Long id;

    @NotNull(message = "CNH is required")
    @NotBlank(message = "CNH is required")
    @Size(max = 10, message = "CNH must be less than 10 characters long")
    @Size(max = 255, message = "CNH must be less than 255 characters long")
    @Pattern(regexp = "[0-9]+")
    private String numeroCNH;

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters long")
    private String nome;

    @NotNull(message = "CPF is required")
    @NotBlank(message = "CPF is required")
    @Size(min = 14, max = 14, message = "CPF must be 14 characters long")
    private String cpf;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;

    @NotNull(message = "Gender is required")
    @Column(name = "genero", nullable = false)
    private Sexo sexo;
}
