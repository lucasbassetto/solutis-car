package com.solutiscar.model.dto.carro;

import com.solutiscar.model.entities.carro.Acessorio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode
public class CarroDTO {

    private Long id;

    @NotNull(message = "Plate is required")
    @NotBlank(message = "Plate is required")
    @Size(min = 1, max = 255, message = "Plate must be between 1 and 255 characters long")
    private String placa;

    @NotNull(message = "Chassis is required")
    @NotBlank(message = "Chassis is required")
    @Size(min = 1, max = 255, message = "Chassis must be between 1 and 255 characters long")
    private String chassi;

    @NotNull(message = "Color is required")
    @NotBlank(message = "Color is required")
    private String cor;

    @NotNull(message = "Daily value is required")
    private BigDecimal valorDiaria;

    @NotNull(message = "Image URL is required")
    @NotBlank(message = "Image URL is required")
    @URL(message = "Image URL must be a valid URL")
    private String imageUrl;

    @NotNull(message = "Model is required")
    private Long modeloCarroId;

    private List<Long> acessorioId; // Lista de IDs de acessórios
}
