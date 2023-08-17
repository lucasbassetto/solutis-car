package com.solutiscar.repositories;

import com.solutiscar.model.entities.Motorista;
import com.solutiscar.model.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
