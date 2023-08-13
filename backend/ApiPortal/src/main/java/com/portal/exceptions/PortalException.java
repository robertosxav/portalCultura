package com.portal.exceptions;

public class PortalException extends RuntimeException{

	private static final long serialVersionUID = -409889946864421783L;

	public PortalException(String message, Throwable cause) {
		super(message, cause);
	}

	public PortalException(String message) {
		super(message);
	}
	
}
