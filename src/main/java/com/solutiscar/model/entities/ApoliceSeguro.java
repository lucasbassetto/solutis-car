package com.solutiscar.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_apolice_seguro")
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private BigDecimal valorFranquia;

    private boolean protecaoTerceiro = false;

    private boolean protecaoCausasNaturais = false;

    private boolean protecaoRoubo = false;

//    @JsonIgnore
    @OneToOne
    @MapsId
    private Aluguel aluguel;
}
