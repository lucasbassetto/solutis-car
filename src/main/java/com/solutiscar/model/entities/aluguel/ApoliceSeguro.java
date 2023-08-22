package com.solutiscar.model.entities.aluguel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_apolice_seguro")
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private BigDecimal valorFranquia;

    @Column(nullable = false)
    private boolean protecaoTerceiro = false;

    @Column(nullable = false)
    private boolean protecaoCausasNaturais = false;

    @Column(nullable = false)
    private boolean protecaoRoubo = false;

    @JsonIgnore
    @OneToOne
    private Aluguel aluguel;
}
