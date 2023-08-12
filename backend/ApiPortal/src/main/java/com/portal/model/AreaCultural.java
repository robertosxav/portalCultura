package com.portal.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "public.area_cultural") 
public class AreaCultural implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_cultural_id")
	private Long areaCulturalId;

	@Column(name = "area_cultural_nome")
	private String areaCulturalNome;

	@Column(name = "area_cultural_ativo")
	private Integer areaCulturalAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "area_cultural_inc_em")
	private Date areaCulturalIncEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "area_cultural_alt_em")
	private Date areaCulturalAltEm;

	public Long getAreaCulturalId() {
		return areaCulturalId;
	}
	 
	public void setAreaCulturalId(Long areaCulturalId) {
		this.areaCulturalId = areaCulturalId;
	}
	 
	public String getAreaCulturalNome() {
		return areaCulturalNome;
	}
	 
	public void setAreaCulturalNome(String areaCulturalNome) {
		this.areaCulturalNome = areaCulturalNome;
	}
	 
	public Integer getAreaCulturalAtivo() {
		return areaCulturalAtivo;
	}
	 
	public void setAreaCulturalAtivo(Integer areaCulturalAtivo) {
		this.areaCulturalAtivo = areaCulturalAtivo;
	}
	 
	public Date getAreaCulturalIncEm() {
		return areaCulturalIncEm;
	}
	 
	public void setAreaCulturalIncEm(Date areaCulturalIncEm) {
		this.areaCulturalIncEm = areaCulturalIncEm;
	}
	 
	public Date getAreaCulturalAltEm() {
		return areaCulturalAltEm;
	}
	 
	public void setAreaCulturalAltEm(Date areaCulturalAltEm) {
		this.areaCulturalAltEm = areaCulturalAltEm;
	}
	 

} 
