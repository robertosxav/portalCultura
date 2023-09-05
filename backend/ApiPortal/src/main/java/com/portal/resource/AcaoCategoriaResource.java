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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Acões da Categoria")
@RestController
@RequestMapping("/acoescategoria")
public class AcaoCategoriaResource {

	@Autowired
	private AcaoCategoriaService acaoCategoriaService;

	@Operation(description = "Serviço para criar uma ação da categoria")
	@PostMapping
	public ResponseEntity<AcaoCategoria> criar(@Validated @RequestBody AcaoCategoria acaocategoria) {
		AcaoCategoria acaocategoriaSalva = acaoCategoriaService.salvar(acaocategoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(acaocategoriaSalva);
	}
	
	@Operation(description = "Serviço para atualizar uma ação da categoria")
	@PutMapping("/{codigo}")
	public ResponseEntity<AcaoCategoria> atualizar(@PathVariable final Long codigo, @Validated @RequestBody AcaoCategoria acaocategoria) {
		AcaoCategoria acaocategoriaSalva = acaoCategoriaService.atualizar(codigo, acaocategoria);
		return ResponseEntity.ok(acaocategoriaSalva);
	}

	@Operation(description = "Serviço para buscar uma ação de categoria pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<AcaoCategoria> buscarPeloCodigo(@PathVariable final Long codigo) {
		AcaoCategoria acaocategoria = acaoCategoriaService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(acaocategoria);
	}

	@Operation(description = "Serviço para buscar todas ações de categorias - paginado")
	@GetMapping
	public Page<AcaoCategoria> pesquisar(Pageable pageable) {
		return acaoCategoriaService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas ações de categorias")
	@GetMapping("/all")
	public List<AcaoCategoria> pesquisar() {
		return acaoCategoriaService.listarTodos();
	}
	
	@Operation(description = "Serviço para buscar todas ações de categorias ativas - paginado")
	@GetMapping("ativos/paginado")
	public Page<AcaoCategoria> listarAtivosPaginado(Pageable pageable) {
		return acaoCategoriaService.listarAtivosPaginado(pageable);
	}

	
	@Operation(description = "Serviço para buscar todas ações de categorias ativas - lista")
	@GetMapping("ativos")
	public List<AcaoCategoria> listarAtivos() {
		return acaoCategoriaService.listarAtivos();
	}


	@Operation(description = "Serviço para excluir uma ação da categoria")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable final Long codigo) {
		acaoCategoriaService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}

}