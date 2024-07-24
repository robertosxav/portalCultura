package com.portal.model;

import java.io.Serializable;

import com.portal.model.enuns.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "template",schema="public") 
public class Template implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_TEMPLATE")
	@SequenceGenerator(name = "SEQUENCE_TEMPLATE", sequenceName = "public.template_id", allocationSize = 1)
	@Column(name = "template_id")
	private Long id;

	@NotBlank(message = "Nome da template é obrigatório")
	@Column(name = "template_nome",nullable = false)
	private String nome;

	@Column(name = "template_ativo",nullable = false)
	private StatusEnum status;

	
	public void ativar() {
		this.status = StatusEnum.ATIVO;
	}

	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}

} 
