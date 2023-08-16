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
@Table(name = "producao",schema="public") 
public class Producao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PRODUCAO")
	@SequenceGenerator(name = "SEQUENCE_PRODUCAO", sequenceName = "public.producao_id", allocationSize = 1)
	@Column(name = "producao_id")
	private Long id;

	@Column(name = "producao_nome")
	private String nomeProducao;

	@Column(name = "producao_ativo")
	private StatusEnum producaoAtivo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "producao_inc_em")
	private LocalDate incluidoEm;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "producao_upd_em")
	private LocalDate atualizadoEm;

} 
