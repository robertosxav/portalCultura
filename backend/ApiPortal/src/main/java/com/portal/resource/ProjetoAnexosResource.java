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

import com.portal.model.ProjetoAnexos;
import com.portal.service.ProjetoAnexosService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetoanexos")
public class ProjetoAnexosResource {

	@Autowired
	private ProjetoAnexosService projetoanexosService;

	@PostMapping
	public ResponseEntity<ProjetoAnexos> criar(@Validated @RequestBody ProjetoAnexos projetoanexos, HttpServletResponse response) {
		 ProjetoAnexos projetoanexosSalva = projetoanexosService.salvar(projetoanexos);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoanexosSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoAnexos> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoAnexos projetoanexos = projetoanexosService.buscarPeloCodigo(codigo);
		return projetoanexos != null ? ResponseEntity.ok(projetoanexos) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoAnexos> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoAnexos projetoanexos) {
		ProjetoAnexos projetoanexosSalva = projetoanexosService.atualizar(codigo, projetoanexos);
		return ResponseEntity.ok(projetoanexosSalva);
	}

	@GetMapping
	public Page<ProjetoAnexos> pesquisar(Pageable pageable) {
		return projetoanexosService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoAnexos> pesquisar() {
		return projetoanexosService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoanexosService.remover(codigo);
	}

}