package com.solutiscar.model.dto;

import com.solutiscar.model.entities.Aluguel;
import com.solutiscar.model.entities.Carro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CarroDTO {

    private long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private String imageUrl;
    private List<Aluguel> aluguel;

}
