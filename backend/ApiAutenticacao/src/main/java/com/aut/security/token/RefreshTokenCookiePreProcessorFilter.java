package com.aut.security.token;

import java.io.IOException;
import java.util.Map;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreProcessorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Efetua cast para pegar a instancia do HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;

		// Verifica se a requisição é para solicitar o refresh token e se possui cookies
		if ("/oauth2/token".equalsIgnoreCase(req.getRequestURI())
				&& "refresh_token".equals(req.getParameter("grant_type")) ) {
			// Percorre os cookies da requisição
			for (Cookie cookie : req.getCookies()) {
				// Verifica se o cookie possui o refresToken
				if (cookie.getName().equals("refreshToken")) {
					// Carrega o valor do refresh token
					String refreshToken = cookie.getValue();
					// Efetua a adição do refresh token na requisição
					req = new MyServletRequestWrapper(req, refreshToken);
				}
			}
		}
		// Retorna o fluxo da requisição depois de realizado o tratamento se necessário
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Não necessário na implementação do filtro
	}

	@Override
	public void destroy() {
		// Não necessário na implementação do filtro
	}

	static class MyServletRequestWrapper extends HttpServletRequestWrapper {

		private String refreshToken;

		public MyServletRequestWrapper(HttpServletRequest request, String refreshToken) {
			super(request);
			// Armazena o refresh token
			this.refreshToken = refreshToken;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			// Carrega os parametros da requisição original
			ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
			// Adiciona o parametro refresh_token na requisição
			map.put("refresh_token", new String[] { refreshToken });
			// Trava o mapa de parametros da requisição
			map.setLocked(true);
			// Retorna o novo mapa de requisições
			return map;
		}

	}

}
