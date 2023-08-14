package com.portal.model.enuns;

import com.portal.exceptions.PortalException;

public enum StatusEditalEnum {
	NOVO(0,"NOVO"),
	EM_ANDAMENTO(1,"EM ANDAMENTO"),
	FINALIZADO(2,"FINALIZADO");
	
	private Integer numero;
	private String descricao;
	
	StatusEditalEnum(Integer numero, String descricao) {
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
	
	public static StatusEditalEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(StatusEditalEnum s : StatusEditalEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new PortalException("Código de Status inválido: "+numero);
	}
	
	public static StatusEditalEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new PortalException("Enum inválido: "+descricao);
		}
		
		for(StatusEditalEnum s : StatusEditalEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new PortalException("Enum inválido: "+descricao);
	}
}

