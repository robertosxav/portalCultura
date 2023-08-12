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

import com.portal.model.ProjetoResponsavel;
import com.portal.service.ProjetoResponsavelService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetoresponsavels")
public class ProjetoResponsavelResource {

	@Autowired
	private ProjetoResponsavelService projetoresponsavelService;
	
	@PostMapping
	public ResponseEntity<ProjetoResponsavel> criar(@Validated @RequestBody ProjetoResponsavel projetoresponsavel, HttpServletResponse response) {
		 ProjetoResponsavel projetoresponsavelSalva = projetoresponsavelService.salvar(projetoresponsavel);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoresponsavelSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoResponsavel> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoResponsavel projetoresponsavel = projetoresponsavelService.buscarPeloCodigo(codigo);
		return projetoresponsavel != null ? ResponseEntity.ok(projetoresponsavel) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoResponsavel> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoResponsavel projetoresponsavel) {
		ProjetoResponsavel projetoresponsavelSalva = projetoresponsavelService.atualizar(codigo, projetoresponsavel);
		return ResponseEntity.ok(projetoresponsavelSalva);
	}

	@GetMapping
	public Page<ProjetoResponsavel> pesquisar(Pageable pageable) {
		return projetoresponsavelService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoResponsavel> pesquisar() {
		return projetoresponsavelService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoresponsavelService.remover(codigo);
	}

}