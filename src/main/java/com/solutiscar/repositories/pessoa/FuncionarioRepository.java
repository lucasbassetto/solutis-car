package com.solutiscar.repositories.pessoa;

import com.solutiscar.model.entities.pessoa.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
