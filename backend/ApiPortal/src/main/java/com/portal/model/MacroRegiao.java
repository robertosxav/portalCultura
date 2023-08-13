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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "macro_regiao",schema="public") 
public class MacroRegiao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_MACRO_REGIAO")
	@SequenceGenerator(name = "SEQUENCE_MACRO_REGIAO", sequenceName = "public.macro_regiao_id", allocationSize = 1)
	@Column(name = "macro_regiao_id")
	private Long id;

	@Column(name = "macro_regiao_nome",length = 120)
	private String macroRegiaoNome;

	@Column(name = "macro_regiao_ativo")
	private StatusEnum status; 
	
	public void ativar() {
		this.status = StatusEnum.ATIVO;
	}


} 
