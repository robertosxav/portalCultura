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

import com.portal.model.ProjetoRecurso;
import com.portal.service.ProjetoRecursoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetorecursos")
public class ProjetoRecursoResource {

	@Autowired
	private ProjetoRecursoService projetorecursoService;

	@PostMapping
	public ResponseEntity<ProjetoRecurso> criar(@Validated @RequestBody ProjetoRecurso projetorecurso, HttpServletResponse response) {
		 ProjetoRecurso projetorecursoSalva = projetorecursoService.salvar(projetorecurso);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetorecursoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoRecurso> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoRecurso projetorecurso = projetorecursoService.buscarPeloCodigo(codigo);
		return projetorecurso != null ? ResponseEntity.ok(projetorecurso) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoRecurso> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoRecurso projetorecurso) {
		ProjetoRecurso projetorecursoSalva = projetorecursoService.atualizar(codigo, projetorecurso);
		return ResponseEntity.ok(projetorecursoSalva);
	}

	@GetMapping
	public Page<ProjetoRecurso> pesquisar(Pageable pageable) {
		return projetorecursoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoRecurso> pesquisar() {
		return projetorecursoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetorecursoService.remover(codigo);
	}

}