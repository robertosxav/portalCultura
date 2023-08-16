package com.portal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.PessoaDto;
import com.portal.model.Pessoa;
import com.portal.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Serviços publicos")
@RestController
@RequestMapping("/publicos")
public class PublicoResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@Operation(description = "Serviço para cadastro de uma pessoa")
	@PostMapping("/cadastrarpessoa")
	public ResponseEntity<Pessoa> cadastrarPessoa(@Validated @RequestBody PessoaDto pessoa) {
		Pessoa pessoaSalva = pessoaService.cadastrarPessoa(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
}