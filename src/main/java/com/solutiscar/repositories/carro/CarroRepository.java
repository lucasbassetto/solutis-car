package com.solutiscar.repositories.carro;

import com.solutiscar.model.entities.carro.Carro;
import com.solutiscar.model.entities.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
