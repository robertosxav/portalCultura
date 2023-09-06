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

import com.portal.model.LinhaAcao;
import com.portal.service.LinhaAcaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Linhas de Ações")
@RestController
@RequestMapping("/linhasacoes")
public class LinhaAcaoResource {

	@Autowired
	private LinhaAcaoService linhaAcaoService;
	
	@Operation(description = "Serviço para criar uma linha de ação")
	@PostMapping
	public ResponseEntity<LinhaAcao> criar(@Validated @RequestBody LinhaAcao linhaAcao) {
		 LinhaAcao linhaAcaoSalva = linhaAcaoService.salvar(linhaAcao);
		return ResponseEntity.status(HttpStatus.CREATED).body(linhaAcaoSalva);
	}
	
	@Operation(description = "Serviço para atualizar uma linha de ação")
	@PutMapping("/{codigo}")
	public ResponseEntity<LinhaAcao> atualizar(@PathVariable final Long codigo, @Validated @RequestBody LinhaAcao linhaAcao) {
		LinhaAcao linhaAcaoSalva = linhaAcaoService.atualizar(codigo, linhaAcao);
		return ResponseEntity.ok(linhaAcaoSalva);
	}

	@Operation(description = "Serviço para buscar uma linha de ação pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<LinhaAcao> buscarPeloCodigo(@PathVariable Long codigo) {
		LinhaAcao linhaAcao = linhaAcaoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(linhaAcao);
	}

	@Operation(description = "Serviço para buscar todas linhas de ações - paginado")
	@GetMapping
	public Page<LinhaAcao> pesquisar(Pageable pageable) {
		return linhaAcaoService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas linhas de ações")
	@GetMapping("/all")
	public List<LinhaAcao> pesquisar() {
		return linhaAcaoService.listarTodos();
	}
	
	@Operation(description = "Serviço para buscar todas linhas de ações ativas - paginado")
	@GetMapping("ativos/paginado")
	public Page<LinhaAcao> listarAtivosPaginado(Pageable pageable) {
		return linhaAcaoService.listarAtivosPaginado(pageable);
	}
	
	@Operation(description = "Serviço para buscar todas linhas de ações ativas - lista")
	@GetMapping("ativos")
	public List<LinhaAcao> listarAtivos() {
		return linhaAcaoService.listarAtivos();
	}
	
	@Operation(description = "Serviço para excluir uma linha de ação")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		linhaAcaoService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}

}