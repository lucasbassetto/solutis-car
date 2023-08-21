package com.solutiscar.model.entities.carrinho;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.pessoa.Motorista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Table(name = "tb_carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Motorista motorista;

    @JsonIgnore
    @OneToMany(mappedBy = "carrinho", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aluguel> alugueis = new ArrayList<>();
}
