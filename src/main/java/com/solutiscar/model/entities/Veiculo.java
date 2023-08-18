package com.solutiscar.model.entities;

import com.solutiscar.model.entities.enums.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cor;
    private Float preco;
    private String placa;
    private Boolean reservado;
    private String modelo;
    private Categoria categoria;

}
