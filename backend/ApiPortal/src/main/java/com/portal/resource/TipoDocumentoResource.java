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

import com.portal.model.TipoDocumento;
import com.portal.service.TipoDocumentoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tiposdocumento")
public class TipoDocumentoResource {

	@Autowired
	private TipoDocumentoService tipodocumentoService;

	@PostMapping
	public ResponseEntity<TipoDocumento> criar(@Validated @RequestBody TipoDocumento tipodocumento, HttpServletResponse response) {
		 TipoDocumento tipodocumentoSalva = tipodocumentoService.salvar(tipodocumento);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipodocumentoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<TipoDocumento> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoDocumento tipodocumento = tipodocumentoService.buscarPeloCodigo(codigo);
		return tipodocumento != null ? ResponseEntity.ok(tipodocumento) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<TipoDocumento> atualizar(@PathVariable Long codigo, @Validated @RequestBody TipoDocumento tipodocumento) {
		TipoDocumento tipodocumentoSalva = tipodocumentoService.atualizar(codigo, tipodocumento);
		return ResponseEntity.ok(tipodocumentoSalva);
	}

	@GetMapping
	public Page<TipoDocumento> pesquisar(Pageable pageable) {
		return tipodocumentoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<TipoDocumento> pesquisar() {
		return tipodocumentoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		tipodocumentoService.remover(codigo);
	}

}