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

import com.portal.model.TipoDocumento;
import com.portal.service.TipoDocumentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tipos de documentos")
@RestController
@RequestMapping("/tiposdocumento")
public class TipoDocumentoResource {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@Operation(description = "Serviço para criar um tipo de documento")
	@PostMapping
	public ResponseEntity<TipoDocumento> criar(@Validated @RequestBody TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoSalva = tipoDocumentoService.salvar(tipoDocumento);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoSalva);
	}

	@Operation(description = "Serviço para atualizar um tipo de documento")
	@PutMapping("/{codigo}")
	public ResponseEntity<TipoDocumento> atualizar(@PathVariable final Long codigo, @Validated @RequestBody TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoSalva = tipoDocumentoService.atualizar(codigo, tipoDocumento);
		return ResponseEntity.ok(tipoDocumentoSalva);
	}
	
	@Operation(description = "Serviço para buscar um tipo de documento pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<TipoDocumento> buscarPeloCodigo(@PathVariable final Long codigo) {
		TipoDocumento tipoDocumento = tipoDocumentoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(tipoDocumento);
	}
	
	@Operation(description = "Serviço para buscar todos tipos de documentos - paginado")
	@GetMapping
	public Page<TipoDocumento> pesquisar(Pageable pageable) {
		return tipoDocumentoService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todos tipos de documentos")
	@GetMapping("/all")
	public List<TipoDocumento> pesquisar() {
		return tipoDocumentoService.listarTodos();
	}

	@Operation(description = "Serviço para exlcuir um tipo de documento - exclusão lógica")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		tipoDocumentoService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}

}