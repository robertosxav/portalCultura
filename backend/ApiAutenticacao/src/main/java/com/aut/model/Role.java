package com.aut.model;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import com.aut.model.enums.RoleName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_ROLE")
	@SequenceGenerator(name = "SEQUENCE_ROLE",sequenceName = "role_id",allocationSize = 1)
    @Column(name="role_id")
    private Long roleId;
    
    @Enumerated(EnumType.STRING)
    @Column(name="nome_role",nullable = false, unique = true)
    private RoleName nomeRole;


    @Override
    public String getAuthority() {
        return this.nomeRole.toString();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

	public RoleName getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(RoleName nomeRole) {
		this.nomeRole = nomeRole;
	}

    
}