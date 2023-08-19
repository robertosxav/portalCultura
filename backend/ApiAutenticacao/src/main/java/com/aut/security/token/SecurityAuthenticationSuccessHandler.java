package com.aut.security.token;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		OAuth2AccessTokenAuthenticationToken accessTokenAuthentication = (OAuth2AccessTokenAuthenticationToken) authentication;
		OAuth2AccessToken accessToken = accessTokenAuthentication.getAccessToken();
		OAuth2RefreshToken refreshToken = accessTokenAuthentication.getRefreshToken();
		
				
		Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken.getTokenValue());
		// Seta o cookie somente de leitura
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(false); // TODO: Mudar para true em produção
		// Seta o path da aplicação
		refreshTokenCookie.setPath(request.getContextPath() + "/oauth2/token");
		// Seta a validade do cookie
		refreshTokenCookie.setMaxAge(14400);
		// Adiciona o refresh token no cookie
		response.addCookie(refreshTokenCookie);
		
		OAuth2AccessTokenResponse.Builder builder =
				OAuth2AccessTokenResponse.withToken(accessToken.getTokenValue())
						.tokenType(accessToken.getTokenType())
						.scopes(accessToken.getScopes());
		if (accessToken.getIssuedAt() != null && accessToken.getExpiresAt() != null) {
			builder.expiresIn(ChronoUnit.SECONDS.between(accessToken.getIssuedAt(), accessToken.getExpiresAt()));
		}
		if (refreshToken != null) {
			builder.refreshToken(refreshToken.getTokenValue());
		}
		
		OAuth2AccessTokenResponse accessTokenResponse = builder.build();
		
		
		System.out.println(accessTokenResponse.getAccessToken().getExpiresAt().getEpochSecond());
		long expire_in = accessTokenResponse.getAccessToken().getExpiresAt().getEpochSecond();
		String access_token = accessTokenResponse.getAccessToken().getTokenValue();
		String token_type = accessTokenResponse.getAccessToken().getTokenType().getValue();
		
		TokenResponse tokenResponse = new TokenResponse(token_type, expire_in ,access_token);
		
		ObjectMapper  ow = new ObjectMapper();
		String json = ow.writeValueAsString(tokenResponse);
		response.getWriter().write(json);
		response.setContentType("application/json");
		
	}

	

}
