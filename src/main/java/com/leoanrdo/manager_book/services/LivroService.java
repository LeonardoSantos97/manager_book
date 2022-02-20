package com.leoanrdo.manager_book.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.Cliente;
import com.leoanrdo.manager_book.domain.Livro;
import com.leoanrdo.manager_book.domain.dtos.LivrosDTO;
import com.leoanrdo.manager_book.repositories.LivroRepository;
import com.leoanrdo.manager_book.services.exceptions.ObjectnotFoundExceptions;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private ClienteService clienteService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundExceptions("Objeto não encontrado ID: " + id));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro create(@Valid LivrosDTO objDTO) {
		return repository.save(newLivro(objDTO));
	}

	public Livro update(Integer id, @Valid LivrosDTO objDTO) {
		objDTO.setId(id);
		Livro oldObj = findById(id);
		oldObj = newLivro(objDTO);
		return repository.save(oldObj);
	}
	
	private Livro newLivro(LivrosDTO obj) {
//		Admin admin = adminService.findById(obj.getAdmin());
//		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Livro livro = new Livro();
		if (obj.getId() != null) {
			livro.setId(obj.getId());
		}
		
//		livro.setAdmin(admin);
//		livro.setCliente(cliente);
		livro.setTitulo(obj.getTitulo());
		return livro;
		
	}

	
	
	
}
