package com.victor.sistemaagricola.funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Funcionario")
@Table(name = "Funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {
	
	public Funcionario(DadosCadastroFuncionario dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.idade = dados.idade();
		this.funcao = dados.funcao();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private int idade;
	private Boolean ativo;
	
	@Enumerated(EnumType.STRING)
	private Funcao funcao;

	public void atualizarInformacoes(@Valid DadosListagemFuncionario dados) {
		
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.idade() != null) {
			this.idade = dados.idade();
		}
		
		if(dados.funcao() != null) {
			this.funcao = dados.funcao();
		}
		
	}

	public void inativar() {
		this.ativo = false;
		
	}
	
	public void ativar() {
		this.ativo = true;
	}
		
	}

