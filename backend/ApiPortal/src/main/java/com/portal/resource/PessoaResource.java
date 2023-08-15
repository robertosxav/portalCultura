package com.portal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.PessoaDto;
import com.portal.model.Pessoa;
import com.portal.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pessoas")
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@Operation(description = "Serviço para cadastro de uma pessoa")
	@PostMapping
	public ResponseEntity<Pessoa> cadastrarPessoa(@Validated @RequestBody PessoaDto pessoa) {
		Pessoa pessoaSalva = pessoaService.cadastrarPessoa(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@Operation(description = "Serviço para atualizar uma pessoa")
	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable final Long codigo, @Validated @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizarPessoa(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}

	@Operation(description = "Serviço para buscar uma pessoa pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
		Pessoa pessoa = pessoaService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(pessoa);
	}

	@Operation(description = "Serviço para buscar todas pessoas - paginado")
	@GetMapping
	public Page<Pessoa> pesquisar(Pageable pageable) {
		return pessoaService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas pessoas")
	@GetMapping("/all")
	public List<Pessoa> pesquisar() {
		return pessoaService.listarTodos();
	}

	/*@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		pessoaService.remover(codigo);
		return ResponseEntity.ok("")
	}*/

}