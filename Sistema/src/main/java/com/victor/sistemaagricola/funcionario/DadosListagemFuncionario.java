package com.victor.sistemaagricola.funcionario;

public record DadosListagemFuncionario(
		Boolean ativo,
		Long id,
		String nome, 
		Integer idade, 
		Funcao funcao) {
	
	public DadosListagemFuncionario(Funcionario funcionario) {
		this(funcionario.getAtivo() ,funcionario.getId(),funcionario.getNome(),funcionario.getIdade(),funcionario.getFuncao());
}}