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
@Table(name = "micro_regiao",schema="public") 
public class MicroRegiao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_MICRO_REGIAO")
	@SequenceGenerator(name = "SEQUENCE_MICRO_REGIAO", sequenceName = "public.micro_regiao_id", allocationSize = 1)
	@Column(name = "micro_regiao_id")
	private Long id;

	@NotBlank(message = "Nome da micro região é obrigatória")
	@Column(name = "micro_regiao_nome",length = 120,nullable = false)
	private String nomeMicroRegiao;

	@Column(name = "micro_regiao_ativo",nullable = false)
	private StatusEnum status;

	@ManyToOne
	@JoinColumn(name="id",referencedColumnName  = "macro_regiao_id")
	private MacroRegiao macroRegiao;

	public void ativar() {
		this.status = StatusEnum.ATIVO;
	}
} 
