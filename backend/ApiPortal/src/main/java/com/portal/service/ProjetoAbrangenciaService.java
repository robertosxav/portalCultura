package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.MicroRegiao;
import com.portal.model.Projeto;
import com.portal.model.ProjetoAbrangencia;
import com.portal.repository.ProjetoAbrangenciaRepository;

@Service
public class ProjetoAbrangenciaService {

	@Autowired
	private ProjetoAbrangenciaRepository projetoAbrangenciaRepository;

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private MicroRegiaoService microRegiaoService;
	
	public ProjetoAbrangencia adicionarAbrangecia(ProjetoAbrangencia projetoAbrangencia) {
		validar(projetoAbrangencia);
		return projetoAbrangenciaRepository.save(projetoAbrangencia);
	}


	public ProjetoAbrangencia atualizar(Long codigo, ProjetoAbrangencia projetoAbrangencia) {
		ProjetoAbrangencia projetoAbrangenciaSalvo = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoAbrangencia, projetoAbrangenciaSalvo, "id");
		return projetoAbrangenciaRepository.save(projetoAbrangenciaSalvo);
	}
	
	public ProjetoAbrangencia buscarPeloCodigo(Long codigo) {
		ProjetoAbrangencia projetoAbrangenciaSalvo = projetoAbrangenciaRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));		
		return projetoAbrangenciaSalvo;
	}

	public Page<ProjetoAbrangencia> pesquisar(Pageable pageable){
		return projetoAbrangenciaRepository.findAll(pageable);
	}

	public List<ProjetoAbrangencia> listarTodos() {
		return projetoAbrangenciaRepository.findAll();
	}

	/*public void remover(Long codigo) {
		projetoAbrangenciaRepository.deleteById(codigo);
	}*/
	
	private void validar(ProjetoAbrangencia projetoAbrangencia) {
		Projeto projeto = projetoService.buscarPeloCodigo(projetoAbrangencia.getId());
		projetoAbrangencia.setProjeto(projeto);
		
		MicroRegiao microRegiao = microRegiaoService.buscarPeloCodigo(projetoAbrangencia.getId());
		projetoAbrangencia.setMicroRegiao(microRegiao);
	}


	public List<ProjetoAbrangencia> listarPorProjeto(Long idProjeto) {
		return projetoAbrangenciaRepository.listarPorProjeto(idProjeto);
	}
}