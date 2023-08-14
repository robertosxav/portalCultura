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

import com.portal.model.MacroRegiao;
import com.portal.service.MacroRegiaoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/macroregioes")
public class MacroRegiaoResource {

	@Autowired
	private MacroRegiaoService macroregiaoService;

	@PostMapping
	public ResponseEntity<MacroRegiao> criar(@Validated @RequestBody MacroRegiao macroregiao, HttpServletResponse response) {
		 MacroRegiao macroregiaoSalva = macroregiaoService.salvar(macroregiao);
		return ResponseEntity.status(HttpStatus.CREATED).body(macroregiaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<MacroRegiao> buscarPeloCodigo(@PathVariable Long codigo) {
		MacroRegiao macroregiao = macroregiaoService.buscarPeloCodigo(codigo);
		return macroregiao != null ? ResponseEntity.ok(macroregiao) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<MacroRegiao> atualizar(@PathVariable Long codigo, @Validated @RequestBody MacroRegiao macroregiao) {
		MacroRegiao macroregiaoSalva = macroregiaoService.atualizar(codigo, macroregiao);
		return ResponseEntity.ok(macroregiaoSalva);
	}

	@GetMapping
	public Page<MacroRegiao> pesquisar(Pageable pageable) {
		return macroregiaoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<MacroRegiao> pesquisar() {
		return macroregiaoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		macroregiaoService.remover(codigo);
	}

}