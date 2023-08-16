package com.portal.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portal.model.enuns.TipoPessoaEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "pessoa",schema="public") 
public class Pessoa implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PESSOA")
	@SequenceGenerator(name = "SEQUENCE_PESSOA", sequenceName = "public.pessoa_id", allocationSize = 1)
	@Column(name = "pessoa_id")
	private Long id;

	@Column(name = "pessoa_nome",nullable = true)
	private String nome;
	
	@Column(name = "pessoa_nome_fantasia",nullable = true)
	private String nomeFantasia;
	
	@Column(name = "pessoa_razao_social",nullable = true)
	private String razaoSocial;
	
	@Column(name = "pessoa_cnpj",nullable = true)
	private String cnpj;
	
	@Column(name = "pessoa_insc_estadual",nullable = true)
	private String inscEstadual;
	
	@Column(name = "pessoa_insc_municipal",nullable = true)
	private String inscMunicipal;
	
	@Column(name = "pessoa_mei",nullable = true)
	private Boolean mei;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoaEnum tipoPessoa;

	@Column(name = "pessoa_cpf",nullable = false,unique = true)
	private String cpf;

	@Column(name = "pessoa_rg",nullable = true)
	private String rg;

	@Column(name = "pessoa_orgao_expeditor",nullable = true)
	private String orgaoExpeditor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "pessoa_data_nasc",nullable = true)
	private LocalDate dataNasc;

	@Column(name = "pessoa_email",nullable = false)
	private String email;

	@Column(name = "pessoa_email_alter",nullable = true)
	private String emailAlter;

	@Column(name = "pessoa_telefone",nullable = true)
	private String telefone;

	@Column(name = "pessoa_celular",nullable = false)
	private String celular;

	@Column(name = "pessoa_cep",nullable = true)
	private String cep;

	@Column(name = "pessoa_endereco",nullable = true)
	private String endereco;

	@Column(name = "pessoa_numero",nullable = true)
	private String numero;

	@Column(name = "pessoa_complemento",nullable = true)
	private String complemento;

	@Column(name = "pessoa_bairro",nullable = true)
	private String bairro;

	@Column(name = "pessoa_municipio",nullable = true)
	private String municipio;

	@Column(name = "pessoa_uf",nullable = true)
	private String uf;

	public Pessoa(String nome, String cpf, String email, String celular) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
	}

	public Pessoa(String nome, String nomeFantasia, String razaoSocial, String cnpj,String cpf, 
			String inscEstadual,String inscMunicipal,String email, String celular, Boolean mei,
			TipoPessoaEnum tipoPessoa) {
		super();
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.inscMunicipal = inscMunicipal;
		this.mei = mei;
		this.tipoPessoa = tipoPessoa;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
	}
	
	

} 
