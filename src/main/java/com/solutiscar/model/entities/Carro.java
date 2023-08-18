package com.solutiscar.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutiscar.model.entities.enums.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.*;

@Data
@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
    @Column(nullable = false, unique = true)
    private String placa;

    @NotBlank(message = "O chassi é obrigatório")
    @Size(min = 17, max = 17, message = "O chassi deve ter 17 caracteres")
    @Column(nullable = false, unique = true)
    private String chassi;

    @NotBlank(message = "A cor é obrigatória")
    @Size(min = 3, max = 200, message = "A cor deve ter entre 3 e 200 caracteres")
    private String cor;

    @NotBlank(message = "O valor da diária é obrigatório")
    @Column(nullable = false)
    private BigDecimal valorDiaria;

    @NotBlank(message = "A imagem é obrigatória")
    @Size(min = 3, max = 200, message = "A imagem deve ter entre 3 e 200 caracteres")
    @URL(message = "A imagem deve ser uma URL válida")
    @Column(nullable = false)
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_carro_acessorio", joinColumns = @JoinColumn(name = "carro_id"), inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    private Set<Acessorio> acessorios = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modeloCarro;
}
