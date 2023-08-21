package com.solutiscar.model.dto.aluguel;

import com.solutiscar.model.entities.aluguel.ApoliceSeguro;
import com.solutiscar.model.entities.carro.Carro;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@EqualsAndHashCode
public class AluguelDTO {

    private Long id;

    @NotNull(message = "Rent date is required")
    private Instant dataPedido;

    @NotNull(message = "Start date is required")
    private Instant dataEntrega;

    @NotNull(message = "End date is required")
    private Instant dataDevolucao;

    @NotNull(message = "Total value is required")
    private BigDecimal valorTotal;

    @NotNull(message = "Insurance policy is required")
    private Long apoliceSeguroId;

    @NotNull(message = "Driver is required")
    private Long motoristaId;

    @NotNull(message = "Car is required")
    private Long carroId;

    @NotNull(message = "cart is required")
    private Long carrinhotId;
}
