package com.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.dto.PessoaDto;
import com.portal.exceptions.PortalException;
import com.portal.model.Pessoa;
import com.portal.model.User;
import com.portal.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@Transactional
	public Pessoa cadastrarPessoa(PessoaDto pessoaDto) {
		validar(pessoaDto);
		Pessoa pessoa = new Pessoa(
					pessoaDto.getNome(),
					pessoaDto.getCpf(),
					pessoaDto.getEmail(),
					pessoaDto.getCelular()
				);
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		User user = new User(pessoaDto.getCpf(),pessoaDto.getSenha(),true,true,true,true); 
		
		usuarioService.criarUsuario(user);
		return pessoaSalva;
	}
	
	private void validar(PessoaDto pessoaDto) {
		//Regras de negócio para cadastrar pessoa
		
		//verificar se já existe
		
		Optional<Pessoa> pessoa = pessoaRepository.findByCpf(pessoaDto.getCpf());
		
		if(pessoa.isPresent()) {
			throw new PortalException("CPF já cadastrado");
		}
	
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