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

import com.portal.model.Projeto;
import com.portal.service.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Projetos")
@RestController
@RequestMapping("/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService projetoService;

	@Operation(description = "Serviço para cadastro de um projeto")
	@PostMapping
	public ResponseEntity<Projeto> criar(@Validated @RequestBody Projeto projeto) {
		Projeto projetoSalva = projetoService.salvar(projeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalva);
	}

	@Operation(description = "Serviço para atualizar de um projeto")
	@PutMapping("/{codigo}")
	public ResponseEntity<Projeto> atualizar(@PathVariable final Long codigo, @Validated @RequestBody Projeto projeto) {
		Projeto projetoSalva = projetoService.atualizar(codigo, projeto);
		return ResponseEntity.ok(projetoSalva);
	}
	
	@Operation(description = "Serviço para buscar um projeto pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Projeto> buscarPeloCodigo(@PathVariable final Long codigo) {
		Projeto projeto = projetoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(projeto);
	}

	@Operation(description = "Serviço para buscar todos projetos - paginado")
	@GetMapping
	public Page<Projeto> pesquisar(Pageable pageable) {
		return projetoService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todos projetos")
	@GetMapping("/all")
	public List<Projeto> pesquisar() {
		return projetoService.listarTodos();
	}

	/*@DeleteMapping("/{codigo}")
	public void remover(@PathVariable final Long codigo) {
		projetoService.remover(codigo);
	}*/

}