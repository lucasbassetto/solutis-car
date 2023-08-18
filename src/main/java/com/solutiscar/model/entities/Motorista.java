package com.solutiscar.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_motorista")
public class Motorista extends Pessoa {

    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]+")
    private String numeroCNH;

    @JsonIgnore
    @OneToMany(mappedBy = "motorista")
    private List<Aluguel> alugueis = new ArrayList<>();
}
