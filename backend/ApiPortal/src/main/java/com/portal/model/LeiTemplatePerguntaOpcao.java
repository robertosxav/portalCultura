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
@Table(name = "lei_template_pergunta_opcao",schema="public") 
public class LeiTemplatePerguntaOpcao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_TEMPLATE_PERGUNTA_OPCAO")
	@SequenceGenerator(name = "SEQUENCE_LEI_TEMPLATE_PERGUNTA_OPCAO", sequenceName = "public.lei_template_pergunta_opcao_id", allocationSize = 1)
	@Column(name = "lei_template_pergunta_opcao_id")
	private Long id;

	@NotBlank(message = "Label da opção é obrigatório")
	@Column(name = "lei_template_pergunta_opcao_label",nullable = false)
	private String label;

	@NotBlank(message = "Descrição da opção é obrigatório")
	@Column(name = "lei_template_pergunta_opcao_desc",nullable = false)
	private String descricao;
	
	
	@ManyToOne
	@JoinColumn(name="lei_template_pergunta_id",referencedColumnName  = "lei_template_pergunta_id")
	private LeiTemplatePergunta leiTemplatePergunta;
	

} 
