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

import com.portal.model.AreaCultural;
import com.portal.service.AreaCulturalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Áreas Culturais")
@RestController
@RequestMapping("/areasculturais")
public class AreaCulturalResource {

	@Autowired
	private AreaCulturalService areaCulturalService;

	@Operation(description = "Serviço para criar uma área cultural")
	@PostMapping
	public ResponseEntity<AreaCultural> criar(@Validated @RequestBody AreaCultural areaCultural) {
		 AreaCultural areaCulturalSalva = areaCulturalService.salvar(areaCultural);
		return ResponseEntity.status(HttpStatus.CREATED).body(areaCulturalSalva);
	}

	@Operation(description = "Serviço para atualizar uma área cultural")
	@PutMapping("/{codigo}")
	public ResponseEntity<AreaCultural> atualizar(@PathVariable final Long codigo, @Validated @RequestBody AreaCultural areaCultural) {
		AreaCultural areaCulturalSalva = areaCulturalService.atualizar(codigo, areaCultural);
		return ResponseEntity.ok(areaCulturalSalva);
	}
	
	@Operation(description = "Serviço para buscar uma área cultural pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<AreaCultural> buscarPeloCodigo(@PathVariable Long codigo) {
		AreaCultural areaCultural = areaCulturalService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(areaCultural);
	}

	@Operation(description = "Serviço para buscar todas áreas culturais - paginado")
	@GetMapping
	public Page<AreaCultural> pesquisar(Pageable pageable) {
		return areaCulturalService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas áreas culturais")
	@GetMapping("/all")
	public List<AreaCultural> pesquisar() {
		return areaCulturalService.listarTodos();
	}

	@Operation(description = "Serviço para excluir uma área cultural")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		areaCulturalService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}

}