package com.portal.model.enuns;

import com.portal.exceptions.PortalException;

public enum StatusEnum {
	INATIVO(0,"INATIVO"),
	ATIVO(1,"ATIVO");
	
	private Integer numero;
	private String descricao;
	
	StatusEnum(Integer numero, String descricao) {
		this.numero	=	numero;
		this.descricao	=	descricao;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static StatusEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(StatusEnum s : StatusEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new PortalException("Código de Status inválido: "+numero);
	}
	
	public static StatusEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new PortalException("Enum inválido: "+descricao);
		}
		
		for(StatusEnum s : StatusEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new PortalException("Enum inválido: "+descricao);
	}
}
