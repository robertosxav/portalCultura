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

import com.portal.model.AreaCultural;
import com.portal.service.AreaCulturalService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/areaculturals")
public class AreaCulturalResource {

	@Autowired
	private AreaCulturalService areaculturalService;

	@PostMapping
	public ResponseEntity<AreaCultural> criar(@Validated @RequestBody AreaCultural areacultural, HttpServletResponse response) {
		 AreaCultural areaculturalSalva = areaculturalService.salvar(areacultural);
		return ResponseEntity.status(HttpStatus.CREATED).body(areaculturalSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<AreaCultural> buscarPeloCodigo(@PathVariable Long codigo) {
		AreaCultural areacultural = areaculturalService.buscarPeloCodigo(codigo);
		return areacultural != null ? ResponseEntity.ok(areacultural) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<AreaCultural> atualizar(@PathVariable Long codigo, @Validated @RequestBody AreaCultural areacultural) {
		AreaCultural areaculturalSalva = areaculturalService.atualizar(codigo, areacultural);
		return ResponseEntity.ok(areaculturalSalva);
	}

	@GetMapping
	public Page<AreaCultural> pesquisar(Pageable pageable) {
		return areaculturalService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<AreaCultural> pesquisar() {
		return areaculturalService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		areaculturalService.remover(codigo);
	}

}