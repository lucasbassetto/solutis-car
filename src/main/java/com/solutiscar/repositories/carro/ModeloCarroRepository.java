package com.solutiscar.repositories.carro;

import com.solutiscar.model.entities.carro.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
