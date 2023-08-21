package com.solutiscar.repositories.aluguel;

import com.solutiscar.model.entities.aluguel.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
