package com.portal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.Edital;
import com.portal.service.EditalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Editais")
@RestController
@RequestMapping("/editais")
public class EditalResource {

	@Autowired
	private EditalService editalService;

	@Operation(description = "Serviço para criar um edital")
	@PostMapping
	public ResponseEntity<Edital> criar(@Validated @RequestBody Edital edital) {
		Edital editalSalva = editalService.salvar(edital);
		return ResponseEntity.status(HttpStatus.CREATED).body(editalSalva);
	}

	@Operation(description = "Serviço para atualizar um edital")
	@PutMapping("/{codigo}")
	public ResponseEntity<Edital> atualizar(@PathVariable final Long codigo, @Validated @RequestBody Edital edital) {
		Edital editalSalva = editalService.atualizar(codigo, edital);
		return ResponseEntity.ok(editalSalva);
	}
	
	@Operation(description = "Serviço para buscar um edital pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Edital> buscarPeloCodigo(@PathVariable Long codigo) {
		Edital edital = editalService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(edital);
	}

	@Operation(description = "Serviço para buscar todos editais - paginado")
	@GetMapping
	public Page<Edital> pesquisar(Pageable pageable) {
		return editalService.pesquisar(pageable);
	}

	@Operation(description = "Serviço para buscar todos editais")
	@GetMapping("/all")
	public List<Edital> pesquisar() {
		return editalService.listarTodos();
	}

	/*@Operation(description = "Serviço para excluir um edital")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		editalService.remover(codigo);
		return ResponseEntity.ok("Registro excluído com sucesso");
	}
	*/
}