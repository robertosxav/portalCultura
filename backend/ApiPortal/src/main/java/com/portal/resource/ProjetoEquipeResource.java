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

import com.portal.model.ProjetoEquipe;
import com.portal.service.ProjetoEquipeService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetoequipes")
public class ProjetoEquipeResource {

	@Autowired
	private ProjetoEquipeService projetoequipeService;

	@PostMapping
	public ResponseEntity<ProjetoEquipe> criar(@Validated @RequestBody ProjetoEquipe projetoequipe, HttpServletResponse response) {
		 ProjetoEquipe projetoequipeSalva = projetoequipeService.salvar(projetoequipe);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoequipeSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoEquipe> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoEquipe projetoequipe = projetoequipeService.buscarPeloCodigo(codigo);
		return projetoequipe != null ? ResponseEntity.ok(projetoequipe) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoEquipe> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoEquipe projetoequipe) {
		ProjetoEquipe projetoequipeSalva = projetoequipeService.atualizar(codigo, projetoequipe);
		return ResponseEntity.ok(projetoequipeSalva);
	}

	@GetMapping
	public Page<ProjetoEquipe> pesquisar(Pageable pageable) {
		return projetoequipeService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoEquipe> pesquisar() {
		return projetoequipeService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoequipeService.remover(codigo);
	}

}