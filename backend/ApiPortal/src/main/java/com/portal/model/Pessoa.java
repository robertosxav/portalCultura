package com.portal.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@Column(name = "pessoa_nome",nullable = false)
	private String nome;

	@Column(name = "pessoa_cpf",nullable = false)
	private String cpf;

	@Column(name = "pessoa_rg",nullable = true)
	private String rg;

	@Column(name = "pessoa_orgao_expeditor",nullable = true)
	private String orgaoExpeditor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "pessoa_data_nasc",nullable = true)
	private String dataNasc;

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

} 
