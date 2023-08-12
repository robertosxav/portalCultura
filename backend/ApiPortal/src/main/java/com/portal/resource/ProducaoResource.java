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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.Producao;
import com.portal.service.ProducaoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/producaos")
public class ProducaoResource {

	@Autowired
	private ProducaoService producaoService;

	@PostMapping
	public ResponseEntity<Producao> criar(@Validated @RequestBody Producao producao, HttpServletResponse response) {
		 Producao producaoSalva = producaoService.salvar(producao);
		return ResponseEntity.status(HttpStatus.CREATED).body(producaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Producao> buscarPeloCodigo(@PathVariable Long codigo) {
		Producao producao = producaoService.buscarPeloCodigo(codigo);
		return producao != null ? ResponseEntity.ok(producao) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Producao> atualizar(@PathVariable Long codigo, @Validated @RequestBody Producao producao) {
		Producao producaoSalva = producaoService.atualizar(codigo, producao);
		return ResponseEntity.ok(producaoSalva);
	}

	@GetMapping
	public Page<Producao> pesquisar(Pageable pageable) {
		return producaoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Producao> pesquisar() {
		return producaoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		producaoService.remover(codigo);
	}

}