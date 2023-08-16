package com.portal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigAPI {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		   http.cors().and().csrf().disable()
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//	        .authorizeHttpRequests(authorizeRequests -> {authorizeRequests.requestMatchers("/publicos/**").permitAll().anyRequest().authenticated(); });
//	    
		   
 		   http.cors().and().csrf().disable()
	        .authorizeHttpRequests(authorizeRequests -> {
							try {
								authorizeRequests
								.requestMatchers("/publicos/**").permitAll()
								.requestMatchers("/swagger-ui.html").permitAll()
								.requestMatchers("/swagger-ui/**").permitAll()
				                .requestMatchers("/webjars/**").permitAll()
				                .requestMatchers("/content/**").permitAll()
				                .requestMatchers("/swagger-resources/**").permitAll()
				                .requestMatchers("/api-docs/**").permitAll()
				                .requestMatchers(HttpMethod.GET, "/v3/**").permitAll()
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