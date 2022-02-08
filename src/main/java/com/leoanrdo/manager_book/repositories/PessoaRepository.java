package com.leoanrdo.manager_book.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.manager_book.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	Optional<Pessoa> findByUsuario(String usuario);
}
