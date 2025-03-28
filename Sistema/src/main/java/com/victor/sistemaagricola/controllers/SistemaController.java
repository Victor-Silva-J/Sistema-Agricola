package com.victor.sistemaagricola.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.sistemaagricola.funcionario.DadosAtualizarFuncionario;
import com.victor.sistemaagricola.funcionario.DadosCadastroFuncionario;
import com.victor.sistemaagricola.funcionario.DadosDetalhamentoFuncionario;
import com.victor.sistemaagricola.funcionario.DadosListagemFuncionario;
import com.victor.sistemaagricola.funcionario.Funcionario;
import com.victor.sistemaagricola.funcionario.FuncionarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/funcionarios")
public class SistemaController {

	@Autowired
	private FuncionarioRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroFuncionario dados) {
			repository.save(new Funcionario(dados));
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemFuncionario>> listar(){
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemFuncionario::new).toList();
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoFuncionario> atualizar(@RequestBody @Valid DadosListagemFuncionario dados) {
		var funcionario =  repository.getReferenceById(dados.id());
		
		funcionario.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional
	public void inativar(@PathVariable Long id) {
		var funcionario = repository.getReferenceById(id);
		funcionario.inativar();
	}
	
	@PutMapping("ativar/{id}")
	@Transactional
	public void ativar(@PathVariable Long id) {
		var funcionario = repository.getReferenceById(id);
		funcionario.ativar();	}
}
