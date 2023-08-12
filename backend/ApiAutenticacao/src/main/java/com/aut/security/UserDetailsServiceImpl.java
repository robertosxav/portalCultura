package com.aut.security;

import org.springframework.stereotype.Service;

@Service
//@Transactional
public class UserDetailsServiceImpl /*implements UserDetailsService*/{
	
	/*private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	}

	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = userRepository.findByUsername(username)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("Usuário não encontrado com username : "+ username));
          Set<GrantedAuthority> authorities = user
        		  .getRoles()
        		  .stream()
        		  .map((role) -> new SimpleGrantedAuthority(role.getNomeRole().toString())).collect(Collectors.toSet());
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true, authorities);
    }*/
}

