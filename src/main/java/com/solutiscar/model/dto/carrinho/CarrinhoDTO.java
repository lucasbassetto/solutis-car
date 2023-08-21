package com.solutiscar.model.dto.carrinho;

import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.pessoa.Motorista;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class CarrinhoDTO {

    private Long id;

    @NotNull(message = "Driver is required")
    private Long motoristaId;

    private List<Aluguel> alugueisId = new ArrayList<>();
}
