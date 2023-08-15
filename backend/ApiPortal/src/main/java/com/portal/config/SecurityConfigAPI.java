package com.portal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigAPI {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		   http
	        .authorizeHttpRequests(authorizeRequests -> {
							try {
								authorizeRequests
								.requestMatchers("/publicos/**").permitAll()
								 .anyRequest().authenticated()
							 	 .and()
						         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						         .and()
						         .oauth2ResourceServer()
						         .jwt();
							} catch (Exception e) {
								e.printStackTrace();
							};
											
						}).httpBasic();
		   		   
		return http.build();
	}
	
}