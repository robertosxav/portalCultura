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

import com.portal.model.ProjetoLinhaAcao;
import com.portal.service.ProjetoLinhaAcaoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/projetolinhaacaos")
public class ProjetoLinhaAcaoResource {

	@Autowired
	private ProjetoLinhaAcaoService projetolinhaacaoService;

	@PostMapping
	public ResponseEntity<ProjetoLinhaAcao> criar(@Validated @RequestBody ProjetoLinhaAcao projetolinhaacao, HttpServletResponse response) {
		 ProjetoLinhaAcao projetolinhaacaoSalva = projetolinhaacaoService.salvar(projetolinhaacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetolinhaacaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoLinhaAcao> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoLinhaAcao projetolinhaacao = projetolinhaacaoService.buscarPeloCodigo(codigo);
		return projetolinhaacao != null ? ResponseEntity.ok(projetolinhaacao) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoLinhaAcao> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoLinhaAcao projetolinhaacao) {
		ProjetoLinhaAcao projetolinhaacaoSalva = projetolinhaacaoService.atualizar(codigo, projetolinhaacao);
		return ResponseEntity.ok(projetolinhaacaoSalva);
	}

	@GetMapping
	public Page<ProjetoLinhaAcao> pesquisar(Pageable pageable) {
		return projetolinhaacaoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoLinhaAcao> pesquisar() {
		return projetolinhaacaoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetolinhaacaoService.remover(codigo);
	}

}