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
@Table(name = "projeto",schema="public") 
public class Projeto implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO")
	@SequenceGenerator(name = "SEQUENCE_PROJETO", sequenceName = "public.projeto_id", allocationSize = 1)
	@Column(name = "projeto_id")
	private Long id;

	@Column(name = "projeto_nome",nullable = false)
	private Integer nomeProjeto;

	@Column(name = "projeto_status",nullable = false)
	private Integer status;

	@ManyToOne()
	@JoinColumn(name = "pessoa_id",referencedColumnName = "pessoa_id",nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne()
	@JoinColumn(name = "producao_id",referencedColumnName = "producao_id",nullable = false)
	private Producao producao;

	@ManyToOne()
	@JoinColumn(name = "area_cultural_id",referencedColumnName = "area_cultural_id",nullable = false)
	private Integer areaCultural;

	@ManyToOne()
	@JoinColumn(name = "edital_id",referencedColumnName = "edital_id",nullable = false)
	private String editalId;

	
} 
