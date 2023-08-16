package com.portal.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "projeto_plano_dist",schema="public") 
public class ProjetoPlanoDist implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO_PLANO_DIST")
	@SequenceGenerator(name = "SEQUENCE_PROJETO_PLANO_DIST", sequenceName = "public.projeto_plano_dist_id", allocationSize = 1)
	@Column(name = "projeto_plano_dist_id")
	private Long id;

	@Column(name = "projeto_plano_dist_espaco",nullable = false)
	private String espaco;

	@Column(name = "projeto_plano_dist_capacidade",nullable = false)
	private String capacidade;

	@Column(name = "projeto_plano_dist_publico",nullable = false)
	private String publico;

	@Column(name = "projeto_plano_dist_acesso",nullable = false)
	private Integer acesso;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "projeto_plano_dist_dta_ini",nullable = false)
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "projeto_plano_dist_dta_fim",nullable = false)
	private LocalDate dataFim;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "projeto_plano_dist_dta_rel_ini",nullable = false)
	private LocalDate dataInicioRel;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "projeto_plano_dist_dta_rel_fim",nullable = false)
	private LocalDate dataFimRel;

	@Column(name = "projeto_plano_dist_comu",nullable = false)
	private String comu;

	@Column(name = "projeto_plano_dist_rec_bruta",nullable = false)
	private String recBruta;

	@Column(name = "projeto_plano_dist_rec_liq",nullable = false)
	private String recLiq;

	@Column(name = "projeto_plano_dist_obs",nullable = false)
	private String obs;

	@ManyToOne()
	@JoinColumn(name = "projeto_id",referencedColumnName = "projeto_id",nullable = false)
	private Projeto projeto;


} 
