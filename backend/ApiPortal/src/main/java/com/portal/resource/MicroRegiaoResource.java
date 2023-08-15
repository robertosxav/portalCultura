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
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.MicroRegiao;
import com.portal.service.MicroRegiaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Micro Regiões")
@RestController
@RequestMapping("/microregioes")
public class MicroRegiaoResource {

	@Autowired
	private MicroRegiaoService microRegiaoService;

	@Operation(description = "Serviço para criar uma micro região")
	@PostMapping
	public ResponseEntity<MicroRegiao> criar(@Validated @RequestBody MicroRegiao microRegiao) {
		MicroRegiao microRegiaoSalva = microRegiaoService.salvar(microRegiao);
		return ResponseEntity.status(HttpStatus.CREATED).body(microRegiaoSalva);
	}
	
	@Operation(description = "Serviço para atualizar uma micro região")
	@PutMapping("/{codigo}")
	public ResponseEntity<MicroRegiao> atualizar(@PathVariable final Long codigo, @Validated @RequestBody MicroRegiao microRegiao) {
		MicroRegiao microRegiaoSalva = microRegiaoService.atualizar(codigo, microRegiao);
		return ResponseEntity.ok(microRegiaoSalva);
	}

	@Operation(description = "Serviço para buscar uma micro região pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<MicroRegiao> buscarPeloCodigo(@PathVariable final Long codigo) {
		MicroRegiao microRegiao = microRegiaoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(microRegiao);
	}

	@Operation(description = "Serviço para buscar todas micro regiões - paginado")
	@GetMapping
	public Page<MicroRegiao> pesquisar(Pageable pageable) {
		return microRegiaoService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas micro regiões")
	@GetMapping("/all")
	public List<MicroRegiao> pesquisar() {
		return microRegiaoService.listarTodos();
	}

	@Operation(description = "Serviço para excluir uma micro região")
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable final Long codigo) {
		microRegiaoService.remover(codigo);
	}

}