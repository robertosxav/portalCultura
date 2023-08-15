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

import com.portal.model.ProjetoPlanoDist;
import com.portal.service.ProjetoPlanoDistService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/planodistprojeto")
public class ProjetoPlanoDistResource {

	@Autowired
	private ProjetoPlanoDistService projetoplanodistService;

	@PostMapping
	public ResponseEntity<ProjetoPlanoDist> criar(@Validated @RequestBody ProjetoPlanoDist projetoplanodist, HttpServletResponse response) {
		 ProjetoPlanoDist projetoplanodistSalva = projetoplanodistService.salvar(projetoplanodist);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoplanodistSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoPlanoDist> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoPlanoDist projetoplanodist = projetoplanodistService.buscarPeloCodigo(codigo);
		return projetoplanodist != null ? ResponseEntity.ok(projetoplanodist) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoPlanoDist> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoPlanoDist projetoplanodist) {
		ProjetoPlanoDist projetoplanodistSalva = projetoplanodistService.atualizar(codigo, projetoplanodist);
		return ResponseEntity.ok(projetoplanodistSalva);
	}

	@GetMapping
	public Page<ProjetoPlanoDist> pesquisar(Pageable pageable) {
		return projetoplanodistService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoPlanoDist> pesquisar() {
		return projetoplanodistService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoplanodistService.remover(codigo);
	}

}