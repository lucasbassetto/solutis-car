package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Aluguel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApoliceSeguroDTO {

    private long id;
    private BigDecimal valorFranquia;
    private boolean protecaoTerceiro = false;
    private boolean protecaoCausasNaturais = false;
    private boolean protecaoRoubo = false;
    private Aluguel aluguel;
}
