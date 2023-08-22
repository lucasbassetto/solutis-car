package com.solutiscar.model.entities.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solutiscar.model.entities.aluguel.Aluguel;
import com.solutiscar.model.entities.aluguel.Carrinho;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

    @Column(unique = true, nullable = false)
    private String numeroCNH;

    @JsonIgnore
    @OneToMany(mappedBy = "motorista")
    private List<Aluguel> alugueis = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "motorista")
    private Carrinho carrinho;
}
