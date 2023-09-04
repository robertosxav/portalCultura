package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.Projeto;
import com.portal.model.ProjetoDados;
import com.portal.repository.ProjetoDadosRepository;

@Service
public class ProjetoDadosService {

	@Autowired
	private ProjetoDadosRepository projetoDadosRepository;

	@Autowired
	private ProjetoService projetoService;
	
	public ProjetoDados adicionarDadosProjeto(ProjetoDados projetoDados) {
		validar(projetoDados);
		return projetoDadosRepository.save(projetoDados);
	}
	
	public ProjetoDados atualizar(Long codigo, ProjetoDados projetoDados) {
		ProjetoDados projetoDadosSalvo = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoDados, projetoDadosSalvo, "id");
		return projetoDadosRepository.save(projetoDadosSalvo);
	}

	public ProjetoDados buscarPeloCodigo(Long codigo) {
		ProjetoDados projetoDadosSalva = projetoDadosRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return projetoDadosSalva;
	}

	public Page<ProjetoDados> pesquisar(Pageable pageable){
		return projetoDadosRepository.findAll(pageable);
	}

	public List<ProjetoDados> listarTodos() {
		return projetoDadosRepository.findAll();
	}

	/*public void remover(Long codigo) {
		projetoDadosRepository.deleteById(codigo);
	}
   */
	
	public List<ProjetoDados> listarPorProjeto(Long idProjeto) {
		return projetoDadosRepository.listarPorProjeto(idProjeto);
	}
	
	private void validar(ProjetoDados projetoDados) {
		Projeto projeto = projetoService.buscarPeloCodigo(projetoDados.getId());
		projetoDados.setProjeto(projeto);
	}

}