package com.portal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.Producao;
import com.portal.service.ProducaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produções")
@RestController
@RequestMapping("/producoes")
public class ProducaoResource {

	@Autowired
	private ProducaoService producaoService;

	@Operation(description = "Serviço para criar uma produção")
	@PostMapping
	public ResponseEntity<Producao> criar(@Validated @RequestBody Producao producao) {
		 Producao producaoSalva = producaoService.salvar(producao);
		return ResponseEntity.status(HttpStatus.CREATED).body(producaoSalva);
	}
	
	@Operation(description = "Serviço para atualizar uma produção")
	@PutMapping("/{codigo}")
	public ResponseEntity<Producao> atualizar(@PathVariable Long codigo, @Validated @RequestBody Producao producao) {
		Producao producaoSalva = producaoService.atualizar(codigo, producao);
		return ResponseEntity.ok(producaoSalva);
	}

	@Operation(description = "Serviço para buscar uma produção pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Producao> buscarPeloCodigo(@PathVariable Long codigo) {
		Producao producao = producaoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(producao);
	}

	@Operation(description = "Serviço para buscar todas produções - paginado")
	@GetMapping
	public Page<Producao> pesquisar(Pageable pageable) {
		return producaoService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas produções")
	@GetMapping("/all")
	public List<Producao> pesquisar() {
		return producaoService.listarTodos();
	}

	@Operation(description = "Serviço para excluir uma produção")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		producaoService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}

}