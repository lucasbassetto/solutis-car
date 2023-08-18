package com.solutiscar.repositories;

import com.solutiscar.model.entities.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
