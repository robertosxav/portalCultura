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
@Table(name = "lei_template",schema="public") 
public class LeiTemplate implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_TEMPLATE")
	@SequenceGenerator(name = "SEQUENCE_LEI_TEMPLATE", sequenceName = "public.lei_template_id", allocationSize = 1)
	@Column(name = "lei_template_id")
	private Long id;

	@NotBlank(message = "Nome da template da lei é obrigatório")
	@Column(name = "lei_template_nome",nullable = false)
	private String nome;

	@Column(name = "lei_template_ativo",nullable = false)
	private StatusEnum status;
	
	@ManyToOne
	@JoinColumn(name="lei_id",referencedColumnName  = "lei_id")
	private Lei lei;
	
		
	public void ativar() {
		this.status = StatusEnum.ATIVO;
	}

	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}

} 
