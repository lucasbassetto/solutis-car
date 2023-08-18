package com.solutiscar.model.dto;

import com.solutiscar.model.entities.ApoliceSeguro;
import com.solutiscar.model.entities.Carro;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class AluguelDTO {

    private long id;
    private Instant dataPedido;
    private Instant dataEntrega;
    private Instant dataDevolucao;
    private BigDecimal valorTotal;
    private Carro carro;
    private ApoliceSeguro apoliceSeguro;
}
