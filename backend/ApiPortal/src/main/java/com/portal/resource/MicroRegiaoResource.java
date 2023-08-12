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

import com.portal.model.MicroRegiao;
import com.portal.service.MicroRegiaoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/microregiaos")
public class MicroRegiaoResource {

	@Autowired
	private MicroRegiaoService microregiaoService;

	@PostMapping
	public ResponseEntity<MicroRegiao> criar(@Validated @RequestBody MicroRegiao microregiao, HttpServletResponse response) {
		 MicroRegiao microregiaoSalva = microregiaoService.salvar(microregiao);
		return ResponseEntity.status(HttpStatus.CREATED).body(microregiaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<MicroRegiao> buscarPeloCodigo(@PathVariable Long codigo) {
		MicroRegiao microregiao = microregiaoService.buscarPeloCodigo(codigo);
		return microregiao != null ? ResponseEntity.ok(microregiao) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<MicroRegiao> atualizar(@PathVariable Long codigo, @Validated @RequestBody MicroRegiao microregiao) {
		MicroRegiao microregiaoSalva = microregiaoService.atualizar(codigo, microregiao);
		return ResponseEntity.ok(microregiaoSalva);
	}

	@GetMapping
	public Page<MicroRegiao> pesquisar(Pageable pageable) {
		return microregiaoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<MicroRegiao> pesquisar() {
		return microregiaoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		microregiaoService.remover(codigo);
	}

}