package com.aut.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aut.model.User;
import com.aut.repository.UserRepository;


public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String username){
          User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException ("Usuário não encontrado com username"));
          Set<GrantedAuthority> authorities = user.getRoles()
        		  					.stream()
        		  					.map((role) -> new SimpleGrantedAuthority(role.getNomeRole().toString()))
        		  									.collect(Collectors.toSet());

        return user;
    }
	
 
	
}

