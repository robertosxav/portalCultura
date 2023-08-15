package com.portal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.AcaoCategoria;
import com.portal.model.LinhaAcao;
import com.portal.repository.LinhaAcaoRepository;

@Service
public class LinhaAcaoService {

	@Autowired
	private LinhaAcaoRepository linhaAcaoRepository;
	
	@Autowired
	private AcaoCategoriaService acaoCategoriaService;

	public LinhaAcao salvar(LinhaAcao linhaAcao) {
		validar(linhaAcao);
		linhaAcao.ativar();
		return linhaAcaoRepository.save(linhaAcao);
	}
	
	public LinhaAcao atualizar(Long codigo, LinhaAcao linhaAcao) {
		LinhaAcao linhaAcaoSave = buscarPeloCodigo(codigo);	
		validar(linhaAcao);	
		BeanUtils.copyProperties(linhaAcao, linhaAcaoSave, "id","status","incluidoEm");
		linhaAcaoSave.setAlteradoEm(LocalDate.now());
		return linhaAcaoRepository.save(linhaAcaoSave);
	}

	public LinhaAcao buscarPeloCodigo(Long codigo) {
		LinhaAcao linhaAcaoSalva = linhaAcaoRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return linhaAcaoSalva;
	}
	
	public Page<LinhaAcao> pesquisar(Pageable pageable){
		return linhaAcaoRepository.findAll(pageable);
	}

	public List<LinhaAcao> listarTodos() {
		return linhaAcaoRepository.findAll();
	}

	public void remover(Long codigo) {
		LinhaAcao linhaAcaoSalva = buscarPeloCodigo(codigo);
		linhaAcaoSalva.inativar();
		linhaAcaoRepository.save(linhaAcaoSalva);
	}
	
	private void validar(LinhaAcao linhaAcao) {
		AcaoCategoria acaoCategoria = acaoCategoriaService.buscarPeloCodigo(linhaAcao.getAcaoCategoria().getId());
		linhaAcao.setAcaoCategoria(acaoCategoria);
	}
}