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
@Table(name = "projeto_linha_acao",schema="public") 
public class ProjetoLinhaAcao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO_LINHA_ACAO")
	@SequenceGenerator(name = "SEQUENCE_PROJETO_LINHA_ACAO", sequenceName = "public.projeto_linha_acao_id", allocationSize = 1)
	@Column(name = "projeto_linha_acao_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "projeto_id",referencedColumnName = "projeto_id",nullable = false)
	private Projeto projeto;

	@ManyToOne
	@JoinColumn(name = "linha_acao_id",referencedColumnName = "linha_acao_id",nullable = false)
	private LinhaAcao linhaAcao;

} 
