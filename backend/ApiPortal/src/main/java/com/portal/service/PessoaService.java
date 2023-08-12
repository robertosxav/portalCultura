package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.Pessoa;
import com.portal.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa buscarPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findById(codigo).get();
		if (pessoaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return pessoaSalva;
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSave, "pessoaId");
		return pessoaRepository.save(pessoaSave);
	}

	public Page<Pessoa> pesquisar(Pageable pageable){
		return pessoaRepository.findAll(pageable);
	}

	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}

	public void remover(Long codigo) {
		pessoaRepository.deleteById(codigo);
	}

}