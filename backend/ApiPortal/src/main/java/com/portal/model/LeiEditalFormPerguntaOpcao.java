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
@Table(name = "lei_edital_form_perg_opcao",schema="public") 
public class LeiEditalFormPerguntaOpcao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_EDITAL_FORM_PERG_OPCAO")
	@SequenceGenerator(name = "SEQUENCE_LEI_EDITAL_FORM_PERG_OPCAO", sequenceName = "public.lei_edital_form_perg_opcao_id", allocationSize = 1)
	@Column(name = "lei_edital_form_perg_opcao_id")
	private Long id;

	@NotBlank(message = "Label da opção é obrigatório")
	@Column(name = "lei_edital_form_perg_opcao_label",nullable = false)
	private String label;

	@NotBlank(message = "Descrição da opção é obrigatório")
	@Column(name = "lei_edital_form_perg_opcao_desc",nullable = false)
	private String descricao;
	
	
	@ManyToOne
	@JoinColumn(name="lei_edital_form_perg_opcao_id",referencedColumnName  = "lei_edital_form_perg_opcao_id")
	private LeiEditalFormPergunta leiTemplatePergunta;
	

} 
