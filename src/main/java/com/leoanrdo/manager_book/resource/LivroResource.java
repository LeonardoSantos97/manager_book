package com.leoanrdo.manager_book.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<LivrosDTO>> findAll(){
		List<Livro> list = service.findAll();
		List<LivrosDTO> listDTO = list.stream().map(obj -> new LivrosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<LivrosDTO> create(@Valid @RequestBody LivrosDTO objDTO){
		Livro obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LivrosDTO> update(@PathVariable Integer id, @Valid @RequestBody LivrosDTO objDTO){
		Livro newObj = service.update(id, objDTO);
		return ResponseEntity.ok(new LivrosDTO(newObj));
	}
}
