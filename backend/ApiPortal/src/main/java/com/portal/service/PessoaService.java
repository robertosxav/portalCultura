package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.dto.PessoaDto;
import com.portal.exceptions.PortalException;
import com.portal.model.Pessoa;
import com.portal.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa cadastrarPessoa(PessoaDto pessoaDto) {
		validar(pessoaDto);
		Pessoa pessoa = new Pessoa(
					pessoaDto.getNome(),
					pessoaDto.getCpf(),
					pessoaDto.getEmail(),
					pessoaDto.getCelular()
				);
		
		return pessoaRepository.save(pessoa);
	}
	
	private void validar(PessoaDto pessoaDto) {
		//Regras de negócio para cadastrar pessoa
		
	}

	public Pessoa atualizarPessoa(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSave, "id");
		return pessoaRepository.save(pessoaSave);
	}

	public Pessoa buscarPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));		
		return pessoaSalva;
	}

	public Page<Pessoa> pesquisar(Pageable pageable){
		return pessoaRepository.findAll(pageable);
	}

	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}

/*	public void remover(Long codigo) {
		pessoaRepository.deleteById(codigo);
	}
*/
}