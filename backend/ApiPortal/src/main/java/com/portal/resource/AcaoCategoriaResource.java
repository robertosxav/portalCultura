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

import com.portal.model.AcaoCategoria;
import com.portal.service.AcaoCategoriaService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/acaocategorias")
public class AcaoCategoriaResource {

	@Autowired
	private AcaoCategoriaService acaocategoriaService;

	@PostMapping
	public ResponseEntity<AcaoCategoria> criar(@Validated @RequestBody AcaoCategoria acaocategoria, HttpServletResponse response) {
		 AcaoCategoria acaocategoriaSalva = acaocategoriaService.salvar(acaocategoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(acaocategoriaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<AcaoCategoria> buscarPeloCodigo(@PathVariable Long codigo) {
		AcaoCategoria acaocategoria = acaocategoriaService.buscarPeloCodigo(codigo);
		return acaocategoria != null ? ResponseEntity.ok(acaocategoria) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<AcaoCategoria> atualizar(@PathVariable Long codigo, @Validated @RequestBody AcaoCategoria acaocategoria) {
		AcaoCategoria acaocategoriaSalva = acaocategoriaService.atualizar(codigo, acaocategoria);
		return ResponseEntity.ok(acaocategoriaSalva);
	}

	@GetMapping
	public Page<AcaoCategoria> pesquisar(Pageable pageable) {
		return acaocategoriaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<AcaoCategoria> pesquisar() {
		return acaocategoriaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		acaocategoriaService.remover(codigo);
	}

}