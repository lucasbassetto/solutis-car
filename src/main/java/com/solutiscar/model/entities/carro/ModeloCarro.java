package com.solutiscar.model.entities.carro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutiscar.model.entities.enums.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_modelo")
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @JsonIgnore
    @OneToMany(mappedBy = "modeloCarro")
    private Set<Carro> carros = new HashSet<>();
}
