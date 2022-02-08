package com.leoanrdo.manager_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.manager_book.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
