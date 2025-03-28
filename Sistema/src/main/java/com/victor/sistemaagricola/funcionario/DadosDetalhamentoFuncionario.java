package com.victor.sistemaagricola.funcionario;

public record DadosDetalhamentoFuncionario(
		Long id,
		String nome,
		int idade,
		Funcao funcao,
		Boolean ativo) {
	
	public DadosDetalhamentoFuncionario(Funcionario funcionario) {
		this(funcionario.getId(),
				funcionario.getNome(),
				funcionario.getIdade(),
				funcionario.getFuncao(),
				funcionario.getAtivo());
	}


}