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

import com.portal.model.ProjetoAbrangencia;
import com.portal.service.ProjetoAbrangenciaService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetosabrangencia")
public class ProjetoAbrangenciaResource {

	@Autowired
	private ProjetoAbrangenciaService projetoabrangenciaService;
	
	@PostMapping
	public ResponseEntity<ProjetoAbrangencia> criar(@Validated @RequestBody ProjetoAbrangencia projetoabrangencia, HttpServletResponse response) {
		 ProjetoAbrangencia projetoabrangenciaSalva = projetoabrangenciaService.salvar(projetoabrangencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoabrangenciaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoAbrangencia> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoAbrangencia projetoabrangencia = projetoabrangenciaService.buscarPeloCodigo(codigo);
		return projetoabrangencia != null ? ResponseEntity.ok(projetoabrangencia) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoAbrangencia> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoAbrangencia projetoabrangencia) {
		ProjetoAbrangencia projetoabrangenciaSalva = projetoabrangenciaService.atualizar(codigo, projetoabrangencia);
		return ResponseEntity.ok(projetoabrangenciaSalva);
	}

	@GetMapping
	public Page<ProjetoAbrangencia> pesquisar(Pageable pageable) {
		return projetoabrangenciaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoAbrangencia> pesquisar() {
		return projetoabrangenciaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoabrangenciaService.remover(codigo);
	}

}