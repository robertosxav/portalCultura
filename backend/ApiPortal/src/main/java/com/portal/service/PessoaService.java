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
import com.portal.model.enuns.TipoPessoaEnum;
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
					pessoaDto.getNomeFantasia(),
					pessoaDto.getRazaoSocial(),
					pessoaDto.getCnpj(),
					pessoaDto.getCpf(),
					pessoaDto.getInscEstadual(),
					pessoaDto.getInscMunicipal(),
					pessoaDto.getEmail(),
					pessoaDto.getCelular(),
					pessoaDto.getMei(),
					pessoaDto.getTipoPessoa()
				);
		
		/*
		 * public Pessoa(Long id, String nome, String nomeFantasia, String razaoSocial, String cnpj,String cpf, 
			String inscEstadual,String inscMunicipal,String email, String celular, Boolean mei,
			TipoPessoaEnum tipoPessoa)
		 */
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		if(pessoaDto.getTipoPessoa().equals(TipoPessoaEnum.PESSOA_FISICA)) {	
			User user = new User(pessoaDto.getCpf(),pessoaDto.getSenha(),true,true,true,true); 	
			usuarioService.criarUsuario(user);
		}
		
		if(pessoaDto.getTipoPessoa().equals(TipoPessoaEnum.PESSOA_FISICA)) {	
			User user = new User(pessoaDto.getCnpj(),pessoaDto.getSenha(),true,true,true,true); 
			usuarioService.criarUsuario(user);
		}
		
		
		return pessoaSalva;
	}
	
	private void validar(PessoaDto pessoaDto) {
		//Regras de negócio para cadastrar pessoa
		
		//verificar se já existe
		if(pessoaDto.getTipoPessoa().equals(TipoPessoaEnum.PESSOA_FISICA)) {			
			Optional<Pessoa> pessoaFisica = pessoaRepository.findByCpf(pessoaDto.getCpf());
			if(pessoaFisica.isPresent()) {
				throw new PortalException("CPF já cadastrado");
			}
		}
		
		if(pessoaDto.getTipoPessoa().equals(TipoPessoaEnum.PESSOA_JURIDICA)) {			
			Optional<Pessoa> pessoaJuridica = pessoaRepository.findByCnpj(pessoaDto.getCnpj());
			if(pessoaJuridica.isPresent()) {
				throw new PortalException("CNPJ já cadastrado");
			}
		}
		
	
		//verificar se os emails são iguais
		if(!pessoaDto.getEmail().equals(pessoaDto.getEmailConfirmacao())) {
			throw new PortalException("Os E-mails informados devem ser iguais");
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