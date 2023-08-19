package com.aut.security.token;


public class TokenResponse {
	
	String token_type;
	long expires_in;
	String access_token;	
	
	public TokenResponse(String tokenType, long expiresAt, String accessToken) {
		super();
		this.token_type = tokenType;
		this.expires_in = expiresAt;
		access_token = accessToken;
	}
	
	public String getToken_type() {
		return token_type;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public String getAccess_token() {
		return access_token;
	}
	
	
	
}
