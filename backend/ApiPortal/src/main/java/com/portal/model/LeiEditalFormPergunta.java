package com.portal.model;

import java.io.Serializable;

import com.portal.model.enuns.StatusEnum;

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
@Table(name = "lei_edital_form_pergunta",schema="public") 
public class LeiEditalFormPergunta implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_EDITAL_FORM_PERGUNTA")
	@SequenceGenerator(name = "SEQUENCE_LEI_EDITAL_FORM_PERGUNTA", sequenceName = "public.lei_edital_form_pergunta_id", allocationSize = 1)
	@Column(name = "lei_edital_form_pergunta_id")
	private Long id;

	@NotBlank(message = "Título é obrigatório")
	@Column(name = "lei_edital_form_pergunta_titulo")
	private String titulo;

	@NotBlank(message = "Descrição é obrigatório")
	@Column(name = "lei_edital_form_pergunta_desc")
	private String descricao;
	
	@NotBlank(message = "Tipo é obrigatório")
	@Column(name = "lei_edital_form_pergunta_tipo")
	private String tipo;
	
	
	@Column(name = "lei_edital_form_pergunta_status",nullable = false)
	private StatusEnum status;

	@ManyToOne
	@JoinColumn(name="lei_edital_formulario_id",referencedColumnName  = "lei_edital_formulario_id")
	private LeiEditalFormulario leiEditalFormulario;
} 
