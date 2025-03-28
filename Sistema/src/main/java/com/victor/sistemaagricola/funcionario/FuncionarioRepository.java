package com.victor.sistemaagricola.funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findAllByAtivoTrue();
}
