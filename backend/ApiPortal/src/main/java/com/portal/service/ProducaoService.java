package com.portal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.Producao;
import com.portal.repository.ProducaoRepository;

@Service
public class ProducaoService {

	@Autowired
	private ProducaoRepository producaoRepository;

	public Producao salvar(Producao producao) {
		producao.ativar();
		return producaoRepository.save(producao);
	}


	public Producao atualizar(Long codigo, Producao producao) {
		Producao producaoSalva = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(producao, producaoSalva, "id","status");
		producaoSalva.setAtualizadoEm(LocalDate.now());
		return producaoRepository.save(producaoSalva);
	}
	
	public Producao buscarPeloCodigo(Long codigo) {
		Producao producaoSalva = producaoRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return producaoSalva;
	}

	public Page<Producao> pesquisar(Pageable pageable){
		return producaoRepository.findAll(pageable);
	}

	public List<Producao> listarTodos() {
		return producaoRepository.findAll();
	}

	public void remover(Long codigo) {
		Producao producaoSalva = buscarPeloCodigo(codigo);
		producaoSalva.inativar();
		producaoRepository.save(producaoSalva);
	}

}