package com.victor.sistemaagricola.funcionario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFuncionario(
		@NotNull
		Long id,
		
		String nome,
		int idade,
		Funcao funcao
		) {
	
}
