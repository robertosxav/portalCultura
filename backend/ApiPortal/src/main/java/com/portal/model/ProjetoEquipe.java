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
@Table(name = "projeto_equipe",schema="public") 
public class ProjetoEquipe implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO_EQUIPE")
	@SequenceGenerator(name = "SEQUENCE_PROJETO_EQUIPE", sequenceName = "public.projeto_equipe_id", allocationSize = 1)
	@Column(name = "projeto_equipe_id")
	private Long id;

	@Column(name = "projeto_equipe_nome",length = 120,nullable = false)
	private String nomeEquipe;

	@Column(name = "projeto_equipe_funcao",length = 120,nullable = false)
	private String funcao;

	@Column(name = "projeto_equipe_mini_cv",nullable = false)
	private String miniCv;

	@ManyToOne
	@JoinColumn(name = "projeto_id",referencedColumnName = "projeto_id")
	private Projeto projeto;


} 
