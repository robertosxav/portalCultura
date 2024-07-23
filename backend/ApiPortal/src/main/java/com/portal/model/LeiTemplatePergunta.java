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
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lei_template_pergunta",schema="public") 
public class LeiTemplatePergunta implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_TEMPLATE_PERGUNTA")
	@SequenceGenerator(name = "SEQUENCE_LEI_TEMPLATE_PERGUNTA", sequenceName = "public.lei_template_pergunta_id", allocationSize = 1)
	@Column(name = "lei_template_pergunta_id")
	private Long id;

	@NotBlank(message = "Título da pergunta é obrigatório")
	@Column(name = "lei_template_pergunta_titulo",nullable = false)
	private String titulo;

	@NotBlank(message = "Descrição da pergunta é obrigatório")
	@Column(name = "lei_template_pergunta_desc",nullable = false)
	private String descricao;
	
	@NotBlank(message = "Tipo da pergunta é obrigatório")
	@Column(name = "lei_template_pergunta_tipo",nullable = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="lei_template_id",referencedColumnName  = "lei_template_id")
	private LeiTemplate leiTemplate;
	

} 
