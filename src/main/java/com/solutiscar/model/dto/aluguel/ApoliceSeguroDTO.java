package com.solutiscar.model.dto.aluguel;

import com.solutiscar.model.entities.aluguel.Aluguel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ApoliceSeguroDTO {

    private Long id;

    private BigDecimal valorFranquia;

    private boolean protecaoTerceiro = false;

    private boolean protecaoCausasNaturais = false;

    private boolean protecaoRoubo = false;
}
