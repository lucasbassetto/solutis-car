package com.solutiscar.model.entities.carro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutiscar.model.entities.carro.Carro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @JsonIgnore
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros = new ArrayList<>();
}
