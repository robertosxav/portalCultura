package com.portal.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "template_pergunta",schema="public") 
public class TemplatePergunta implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_TEMPLATE_PERGUNTA")
	@SequenceGenerator(name = "SEQUENCE_TEMPLATE_PERGUNTA", sequenceName = "public.template_pergunta_id", allocationSize = 1)
	@Column(name = "template_pergunta_id")
	private Long id;

	@NotBlank(message = "Título é obrigatório")
	@Column(name = "template_pergunta_titulo",nullable = false)
	private String titulo;
	
	@NotBlank(message = "Descrição é obrigatório")
	@Column(name = "template_pergunta_desc",nullable = false)
	private String descricao;
	
	@NotBlank(message = "Tipo é obrigatório")
	@Column(name = "template_pergunta_tipo",nullable = false)
	private String tipo;

	@Column(name = "template_ativo",nullable = false)
	private StatusEnum status;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "template_pergunta_inc_em",nullable = false)
	private LocalDate incluidoEm;
	
	@ManyToOne
	@JoinColumn(name="template_id",referencedColumnName  = "template_id")
	private Template template;
	
	public void ativar() {
		this.incluidoEm = LocalDate.now();
		this.status = StatusEnum.ATIVO;
	}

	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}

} 
