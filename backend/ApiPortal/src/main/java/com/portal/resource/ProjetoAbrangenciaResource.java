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

import com.portal.model.ProjetoAbrangencia;
import com.portal.service.ProjetoAbrangenciaService;

@RestController
@RequestMapping("/abrangeciasprojeto")
public class ProjetoAbrangenciaResource {

	@Autowired
	private ProjetoAbrangenciaService projetoAbrangenciaService;
	
	@PostMapping
	public ResponseEntity<ProjetoAbrangencia> adicionarAbrangecia(@Validated @RequestBody ProjetoAbrangencia projetoAbrangencia) {
		ProjetoAbrangencia projetoAbrangenciaSalva = projetoAbrangenciaService.adicionarAbrangecia(projetoAbrangencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoAbrangenciaSalva);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ProjetoAbrangencia> atualizar(@PathVariable Long codigo, @Validated @RequestBody ProjetoAbrangencia projetoAbrangencia) {
		ProjetoAbrangencia projetoAbrangenciaSalva = projetoAbrangenciaService.atualizar(codigo, projetoAbrangencia);
		return ResponseEntity.ok(projetoAbrangenciaSalva);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ProjetoAbrangencia> buscarPeloCodigo(@PathVariable Long codigo) {
		ProjetoAbrangencia projetoAbrangencia = projetoAbrangenciaService.buscarPeloCodigo(codigo);
		return projetoAbrangencia != null ? ResponseEntity.ok(projetoAbrangencia) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public Page<ProjetoAbrangencia> pesquisar(Pageable pageable) {
		return projetoAbrangenciaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ProjetoAbrangencia> pesquisar() {
		return projetoAbrangenciaService.listarTodos();
	}

	@GetMapping("/listarporprojeto/{idProjeto}")
	public List<ProjetoAbrangencia> listarPorProjeto(@PathVariable Long idProjeto){
		return projetoAbrangenciaService.listarPorProjeto(idProjeto);
	}
	
	/*@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		projetoAbrangenciaService.remover(codigo);
	}*/

}