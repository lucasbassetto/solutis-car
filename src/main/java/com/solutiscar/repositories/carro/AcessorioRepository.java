package com.solutiscar.repositories.carro;

import com.solutiscar.model.entities.carro.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
}
