package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoPlanoDist;
import com.portal.repository.ProjetoPlanoDistRepository;

@Service
public class ProjetoPlanoDistService {

	@Autowired
	private ProjetoPlanoDistRepository projetoplanodistRepository;

	public ProjetoPlanoDist salvar(ProjetoPlanoDist projetoplanodist) {
		return projetoplanodistRepository.save(projetoplanodist);
	}

	public ProjetoPlanoDist buscarPeloCodigo(Long codigo) {
		ProjetoPlanoDist projetoplanodistSalva = projetoplanodistRepository.findById(codigo).get();
		if (projetoplanodistSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetoplanodistSalva;
	}

	public ProjetoPlanoDist atualizar(Long codigo, ProjetoPlanoDist projetoplanodist) {
		ProjetoPlanoDist projetoplanodistSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoplanodist, projetoplanodistSave, "projetoPlanoDistId");
		return projetoplanodistRepository.save(projetoplanodistSave);
	}

	public Page<ProjetoPlanoDist> pesquisar(Pageable pageable){
		return projetoplanodistRepository.findAll(pageable);
	}

	public List<ProjetoPlanoDist> listarTodos() {
		return projetoplanodistRepository.findAll();
	}

	public void remover(Long codigo) {
		projetoplanodistRepository.deleteById(codigo);
	}

}