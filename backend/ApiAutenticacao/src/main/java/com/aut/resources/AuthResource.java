package com.aut.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aut.dto.AuthenticationDto;
import com.aut.dto.LoginResponseDto;
import com.aut.dto.RegisterDto;
import com.aut.model.User;
import com.aut.repository.UserRepository;
import com.aut.security.TokenService;

@RestController
@RequestMapping("auth")
public class AuthResource {
	 	
		@Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private UserRepository repository;
	    @Autowired
	    private TokenService tokenService;

	    @PostMapping("/login")
	    public ResponseEntity<LoginResponseDto> login(@RequestBody @Validated AuthenticationDto data){
	    	String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
	    	var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), encryptedPassword);
	        var auth = this.authenticationManager.authenticate(usernamePassword);
	        var token = tokenService.generateToken(usernamePassword.getName());
	        return ResponseEntity.ok(new LoginResponseDto(token));   
	    }

	    @PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody @Validated RegisterDto data){
	        if(this.repository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

	        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
	        User newUser = new User(data.username(),encryptedPassword,true,true,true,true,null);
	        		//new User(data.username(), encryptedPassword, data.role());

	        this.repository.save(newUser);

	        return ResponseEntity.ok().build();
	    }
}
