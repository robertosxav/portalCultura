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

import com.portal.model.ProjetoDados;
import com.portal.service.ProjetoDadosService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/dadosprojeto")
public class ProjetoDadosResource {

	@Autowired
	private ProjetoDadosService projetodadosService;

	@PostMapping
	public ResponseEntity<ProjetoDados> criar(@Validated @RequestBody ProjetoDados projetodados, HttpServletResponse response) {
		 ProjetoDados projetodadosSalva = projetodadosService.salvar(projetodados);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetodadosSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoDados> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoDados projetodados = projetodadosService.buscarPeloCodigo(codigo);
		return projetodados != null ? ResponseEntity.ok(projetodados) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoDados> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoDados projetodados) {
		ProjetoDados projetodadosSalva = projetodadosService.atualizar(codigo, projetodados);
		return ResponseEntity.ok(projetodadosSalva);
	}

	@GetMapping
	public Page<ProjetoDados> pesquisar(Pageable pageable) {
		return projetodadosService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoDados> pesquisar() {
		return projetodadosService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetodadosService.remover(codigo);
	}

}