package com.portal.model;

import java.io.Serializable;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_USUARIO")
	@SequenceGenerator(name = "SEQUENCE_USUARIO",sequenceName = "user_id",allocationSize = 1)
    @Column(name="user_id")
    private Long userId;
    
    @Column(name="username",nullable = false, unique = true)
    private String username;
    
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="account_non_expired")
    private Boolean accountNonExpired;
    
    @Column(name="account_non_locked")
    private Boolean accountNonLocked;
	
    @Column(name="credentials_non_expired")
    private Boolean credentialsNonExpired;
	
    @Column(name="enabled")
    private Boolean enabled;

	public User(String username, String password, Boolean accountNonExpired, Boolean accountNonLocked,
			Boolean credentialsNonExpired, Boolean enabled) {
		super();
		this.username = username;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
    
    
}