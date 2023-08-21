package com.solutiscar.model.entities.carro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutiscar.model.entities.aluguel.Aluguel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false, unique = true)
    private String chassi;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private BigDecimal valorDiaria;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_carro_acessorio", joinColumns = @JoinColumn(name = "carro_id"), inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    private List<Acessorio> acessorios = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modeloCarro;
}
