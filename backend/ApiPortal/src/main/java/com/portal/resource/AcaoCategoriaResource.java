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

import com.portal.model.AcaoCategoria;
import com.portal.service.AcaoCategoriaService;

@RestController
@RequestMapping("/acoescategoria")
public class AcaoCategoriaResource {

	@Autowired
	private AcaoCategoriaService acaoCategoriaService;

	@PostMapping
	public ResponseEntity<AcaoCategoria> criar(@Validated @RequestBody AcaoCategoria acaocategoria) {
		AcaoCategoria acaocategoriaSalva = acaoCategoriaService.salvar(acaocategoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(acaocategoriaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<AcaoCategoria> buscarPeloCodigo(@PathVariable final Long codigo) {
		AcaoCategoria acaocategoria = acaoCategoriaService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(acaocategoria);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<AcaoCategoria> atualizar(@PathVariable final Long codigo, @Validated @RequestBody AcaoCategoria acaocategoria) {
		AcaoCategoria acaocategoriaSalva = acaoCategoriaService.atualizar(codigo, acaocategoria);
		return ResponseEntity.ok(acaocategoriaSalva);
	}

	@GetMapping
	public Page<AcaoCategoria> pesquisar(Pageable pageable) {
		return acaoCategoriaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<AcaoCategoria> pesquisar() {
		return acaoCategoriaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable final Long codigo) {
		acaoCategoriaService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}

}