package com.leoanrdo.manager_book.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.leoanrdo.manager_book.domain.enums.Perfil;

public class UserSS implements UserDetails{

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String senha;
	private String usuario;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS(Integer id, String senha, String usuario, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.senha = senha;
		this.usuario = usuario;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toSet());
	}
	
	public Integer getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
