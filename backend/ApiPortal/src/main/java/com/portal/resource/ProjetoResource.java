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

import com.portal.model.Projeto;
import com.portal.service.ProjetoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService projetoService;

	@PostMapping
	public ResponseEntity<Projeto> criar(@Validated @RequestBody Projeto projeto, HttpServletResponse response) {
		 Projeto projetoSalva = projetoService.salvar(projeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Projeto> buscarPeloCodigo(@PathVariable Long codigo) {
		Projeto projeto = projetoService.buscarPeloCodigo(codigo);
		return projeto != null ? ResponseEntity.ok(projeto) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Projeto> atualizar(@PathVariable Long codigo, @Validated @RequestBody Projeto projeto) {
		Projeto projetoSalva = projetoService.atualizar(codigo, projeto);
		return ResponseEntity.ok(projetoSalva);
	}

	@GetMapping
	public Page<Projeto> pesquisar(Pageable pageable) {
		return projetoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Projeto> pesquisar() {
		return projetoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoService.remover(codigo);
	}

}