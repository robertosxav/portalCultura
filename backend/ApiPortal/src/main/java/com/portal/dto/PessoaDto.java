package com.portal.dto;

import java.io.Serializable;

import com.portal.model.enuns.TipoPessoaEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String nomeFantasia;
	
	private String razaoSocial;

	private String cpf;
	
	private String cnpj;
	
	private String inscEstadual;
	
	private String inscMunicipal;
	
	private String email;
	
	private String emailConfirmacao;
	
	private String celular;
	
	private String senha;
	
	private Boolean mei;
	
	private TipoPessoaEnum tipoPessoa;
	
}
