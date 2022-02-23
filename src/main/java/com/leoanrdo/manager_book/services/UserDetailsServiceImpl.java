package com.leoanrdo.manager_book.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Pessoa;
import com.leoanrdo.manager_book.repositories.PessoaRepository;
import com.leoanrdo.manager_book.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private PessoaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Optional<Pessoa> user = repository.findByUsuario(usuario);
		if(user.isPresent()) {
			return new UserSS(user.get().getId(), user.get().getSenha(), user.get().getUsuario(), user.get().getPerfis());
		}
		throw new UsernameNotFoundException(usuario);
	}
	
	

}
