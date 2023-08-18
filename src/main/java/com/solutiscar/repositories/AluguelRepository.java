package com.solutiscar.repositories;

import com.solutiscar.model.entities.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
