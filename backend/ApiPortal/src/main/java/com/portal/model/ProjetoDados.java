package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "projeto_dados",schema="public") 
public class ProjetoDados implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO_DADOS")
	@SequenceGenerator(name = "SEQUENCE_PROJETO_DADOS", sequenceName = "public.projeto_dados_id", allocationSize = 1)
	@Column(name = "projeto_dados_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "projeto_id",referencedColumnName = "projeto_id")
	private Projeto projeto;

	@Column(name = "projeto_dados_resumo",nullable = false)
	private String resumo;

	@Column(name = "projeto_dados_descricao",nullable = false)
	private String descricao;

	@Column(name = "projeto_dados_objetivos",nullable = false)
	private String objetivos;

	@Column(name = "projeto_dados_justificativa",nullable = false)
	private String justificativa;

	@Column(name = "projeto_dados_estrategia",nullable = false)
	private String estrategia;

	@Column(name = "projeto_dados_parcerias",nullable = false)
	private String parcerias;

	@Column(name = "projeto_dados_acessibilidade",nullable = false)
	private String acessibilidade;

	@Column(name = "projeto_dados_produto",nullable = false)
	private String produto;


} 
