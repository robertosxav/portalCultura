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

import com.portal.model.ProjetoCoordenador;
import com.portal.service.ProjetoCoordenadorService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/coordenadoresprojeto")
public class ProjetoCoordenadorResource {

	@Autowired
	private ProjetoCoordenadorService projetocoordenadorService;
	
	@PostMapping
	public ResponseEntity<ProjetoCoordenador> criar(@Validated @RequestBody ProjetoCoordenador projetocoordenador, HttpServletResponse response) {
		 ProjetoCoordenador projetocoordenadorSalva = projetocoordenadorService.salvar(projetocoordenador);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetocoordenadorSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoCoordenador> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoCoordenador projetocoordenador = projetocoordenadorService.buscarPeloCodigo(codigo);
		return projetocoordenador != null ? ResponseEntity.ok(projetocoordenador) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoCoordenador> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoCoordenador projetocoordenador) {
		ProjetoCoordenador projetocoordenadorSalva = projetocoordenadorService.atualizar(codigo, projetocoordenador);
		return ResponseEntity.ok(projetocoordenadorSalva);
	}

	@GetMapping
	public Page<ProjetoCoordenador> pesquisar(Pageable pageable) {
		return projetocoordenadorService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoCoordenador> pesquisar() {
		return projetocoordenadorService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetocoordenadorService.remover(codigo);
	}

}