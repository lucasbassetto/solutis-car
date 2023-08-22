package com.solutiscar.model.entities.aluguel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.pessoa.Motorista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataPedido;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataEntrega;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataDevolucao;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @OneToOne(mappedBy = "aluguel", cascade = CascadeType.ALL)
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "carrinho_id", nullable = false)
    private Carrinho carrinho;
}
