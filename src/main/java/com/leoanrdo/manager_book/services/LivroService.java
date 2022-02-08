package com.leoanrdo.manager_book.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Livro;
import com.leoanrdo.manager_book.repositories.LivroRepository;
import com.leoanrdo.manager_book.services.exceptions.ObjectnotFoundExceptions;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundExceptions("Objeto não encontrado ID: " + id));
	}

}
