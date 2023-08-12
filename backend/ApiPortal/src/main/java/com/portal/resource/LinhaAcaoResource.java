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

import com.portal.model.LinhaAcao;
import com.portal.service.LinhaAcaoService;


@RestController
@RequestMapping("/linhaacaos")
public class LinhaAcaoResource {

	@Autowired
	private LinhaAcaoService linhaacaoService;
	
	@PostMapping
	public ResponseEntity<LinhaAcao> criar(@Validated @RequestBody LinhaAcao linhaacao, jakarta.servlet.http.HttpServletResponse response) {
		 LinhaAcao linhaacaoSalva = linhaacaoService.salvar(linhaacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(linhaacaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<LinhaAcao> buscarPeloCodigo(@PathVariable Long codigo) {
		LinhaAcao linhaacao = linhaacaoService.buscarPeloCodigo(codigo);
		return linhaacao != null ? ResponseEntity.ok(linhaacao) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<LinhaAcao> atualizar(@PathVariable Long codigo, @Validated @RequestBody LinhaAcao linhaacao) {
		LinhaAcao linhaacaoSalva = linhaacaoService.atualizar(codigo, linhaacao);
		return ResponseEntity.ok(linhaacaoSalva);
	}

	@GetMapping
	public Page<LinhaAcao> pesquisar(Pageable pageable) {
		return linhaacaoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<LinhaAcao> pesquisar() {
		return linhaacaoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		linhaacaoService.remover(codigo);
	}

}