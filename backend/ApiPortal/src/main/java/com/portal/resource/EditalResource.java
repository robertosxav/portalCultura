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

import com.portal.model.Edital;
import com.portal.service.EditalService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/editals")
public class EditalResource {

	@Autowired
	private EditalService editalService;

	@PostMapping
	public ResponseEntity<Edital> criar(@Validated @RequestBody Edital edital, HttpServletResponse response) {
		 Edital editalSalva = editalService.salvar(edital);
		return ResponseEntity.status(HttpStatus.CREATED).body(editalSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Edital> buscarPeloCodigo(@PathVariable Long codigo) {
		Edital edital = editalService.buscarPeloCodigo(codigo);
		return edital != null ? ResponseEntity.ok(edital) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Edital> atualizar(@PathVariable Long codigo, @Validated @RequestBody Edital edital) {
		Edital editalSalva = editalService.atualizar(codigo, edital);
		return ResponseEntity.ok(editalSalva);
	}

	@GetMapping
	public Page<Edital> pesquisar(Pageable pageable) {
		return editalService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Edital> pesquisar() {
		return editalService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		editalService.remover(codigo);
	}

}