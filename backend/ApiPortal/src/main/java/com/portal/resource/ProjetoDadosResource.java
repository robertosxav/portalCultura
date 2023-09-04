package com.portal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.ProjetoDados;
import com.portal.service.ProjetoDadosService;

@RestController
@RequestMapping("/dadosprojeto")
public class ProjetoDadosResource {

	@Autowired
	private ProjetoDadosService projetoDadosService;

	@PostMapping
	public ResponseEntity<ProjetoDados> adicionarDadosProjeto(@Validated @RequestBody ProjetoDados projetoDados) {
		ProjetoDados projetoDadosSalva = projetoDadosService.adicionarDadosProjeto(projetoDados);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoDadosSalva);
	}


	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoDados> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoDados projetoDados) {
		ProjetoDados projetoDadosSalva = projetoDadosService.atualizar(codigo, projetoDados);
		return ResponseEntity.ok(projetoDadosSalva);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoDados> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoDados projetoDados = projetoDadosService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(projetoDados);
	}
	
	@GetMapping
	public Page<ProjetoDados> pesquisar(Pageable pageable) {
		return projetoDadosService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoDados> pesquisar() {
		return projetoDadosService.listarTodos();
	}

	/*@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoDadosService.remover(codigo);
	}*/
	
	@GetMapping("listarporprojeto/{idProjeto}")
	public List<ProjetoDados> listarPorProjeto(@PathVariable Long idProjeto){
		return projetoDadosService.listarPorProjeto(idProjeto);
	}

}