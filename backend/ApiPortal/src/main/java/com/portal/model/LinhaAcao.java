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
@Table(name = "linha_acao",schema="public") 
public class LinhaAcao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LINHA_ACAO")
	@SequenceGenerator(name = "SEQUENCE_LINHA_ACAO", sequenceName = "public.linha_acao_id", allocationSize = 1)
	@Column(name = "linha_acao_id")
	private Long id;

	@NotBlank(message = "Nome da linha de ação é orbrigatória")
	@Column(name = "linha_acao_nome",length = 120,nullable = false)
	private String nome;

	@Column(name = "linha_acao_ativo",nullable = false)
	private StatusEnum status;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "linha_acao_inc_em")
	private LocalDate incluidoEm;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "linha_acao_alt_em")
	private LocalDate alteradoEm;

	@ManyToOne
	@JoinColumn(name = "acao_categoria_id",referencedColumnName = "acao_categoria_id")
	private AcaoCategoria acaoCategoria;

	public void ativar() {
		this.incluidoEm = LocalDate.now();
		this.status = StatusEnum.ATIVO;
	}

	public void inativar() {
		this.alteradoEm = LocalDate.now();
		this.status = StatusEnum.INATIVO;
	}
} 
