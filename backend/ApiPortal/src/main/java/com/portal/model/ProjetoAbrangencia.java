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
@Table(name = "projeto_abrangencia",schema="public") 
public class ProjetoAbrangencia implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PROJETO_ABRANGENCIA")
	@SequenceGenerator(name = "SEQUENCE_PROJETO_ABRANGENCIA", sequenceName = "public.projeto_abrangencia_id", allocationSize = 1)
	@Column(name = "projeto_abrangencia_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "projeto_id",referencedColumnName = "projeto_id",nullable = false)
	private Projeto projeto;

	@ManyToOne()
	@JoinColumn(name = "micro_regiao_id",referencedColumnName = "micro_regiao_id",nullable = false)
	private MicroRegiao microRegiao;
} 
