package com.solutiscar.repositories.carro;

import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT DISTINCT c FROM Carro c " +
            "LEFT JOIN c.alugueis r " +
            "WHERE c.alugado = false AND " +
            "(r.dataDevolucao < :startDate OR r.dataPedido > :endDate OR r IS NULL)")
    List<Carro> findAvailableCarsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
