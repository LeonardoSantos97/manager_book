package com.leoanrdo.manager_book.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoanrdo.manager_book.domain.Livro;
import com.leoanrdo.manager_book.domain.dtos.LivrosDTO;
import com.leoanrdo.manager_book.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LivrosDTO> findById(@PathVariable Integer id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(new LivrosDTO(obj));
	}
	
	
}
