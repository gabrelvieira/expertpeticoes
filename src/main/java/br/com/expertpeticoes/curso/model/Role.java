package br.com.expertpeticoes.curso.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	@Override
	public String getAuthority() {
		return "ADMIN";
	}

}
