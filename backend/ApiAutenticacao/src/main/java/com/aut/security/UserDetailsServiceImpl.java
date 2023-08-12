package com.aut.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aut.model.User;
import com.aut.repository.UserRepository;

@Service
//@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	}

	
	@Override
    public UserDetails loadUserByUsername(String username){
          User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException ("Usuário não encontrado com username"));
          Set<GrantedAuthority> authorities = user.getRoles()
        		  					.stream()
        		  					.map((role) -> new SimpleGrantedAuthority(role.getNomeRole().toString()))
        		  									.collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true, authorities);
    }
}

