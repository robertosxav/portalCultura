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

import com.portal.model.MacroRegiao;
import com.portal.service.MacroRegiaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Macro Regiões")
@RestController
@RequestMapping("/macroregioes")
public class MacroRegiaoResource {

	@Autowired
	private MacroRegiaoService macroRegiaoService;

	@Operation(description = "Serviço para criar uma macro região")
	@PostMapping
	public ResponseEntity<MacroRegiao> criar(@Validated @RequestBody MacroRegiao macroRegiao) {
		MacroRegiao macroRegiaoSalva = macroRegiaoService.salvar(macroRegiao);
		return ResponseEntity.status(HttpStatus.CREATED).body(macroRegiaoSalva);
	}
	
	@Operation(description = "Serviço para atualizar uma macro região")
	@PutMapping("/{codigo}")
	public ResponseEntity<MacroRegiao> atualizar(@PathVariable final Long codigo, @Validated @RequestBody MacroRegiao macroRegiao) {
		MacroRegiao macroRegiaoSalva = macroRegiaoService.atualizar(codigo, macroRegiao);
		return ResponseEntity.ok(macroRegiaoSalva);
	}

	@Operation(description = "Serviço para buscar uma macro região pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<MacroRegiao> buscarPeloCodigo(@PathVariable final Long codigo) {
		MacroRegiao macroRegiao = macroRegiaoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(macroRegiao);
	}

	@Operation(description = "Serviço para buscar todas macro regiões - paginado")
	@GetMapping
	public Page<MacroRegiao> pesquisar(Pageable pageable) {
		return macroRegiaoService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todas macro regiões")
	@GetMapping("/all")
	public List<MacroRegiao> pesquisar() {
		return macroRegiaoService.listarTodos();
	}

	@Operation(description = "Serviço para excluir uma macro região")
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable final Long codigo) {
		macroRegiaoService.remover(codigo);
	}

}