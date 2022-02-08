package com.leoanrdo.manager_book.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.Pessoa;
import com.leoanrdo.manager_book.domain.dtos.AdminDTO;
import com.leoanrdo.manager_book.repositories.AdminRepository;
import com.leoanrdo.manager_book.repositories.PessoaRepository;
import com.leoanrdo.manager_book.services.exceptions.DataIntegrityViolationException;
import com.leoanrdo.manager_book.services.exceptions.ObjectnotFoundExceptions;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Admin findById(Integer id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundExceptions("Não encontrado! ID: " + id));
	}

	public List<Admin> findAll() {
		return repository.findAll();
	}

	public Admin create(AdminDTO objDTO) {
		objDTO.setId(null);
		validaPorUsuario(objDTO);
		Admin newObj = new Admin(objDTO);
		return repository.save(newObj);
	}
	
	public Admin update(Integer id, @Valid AdminDTO objDTO) {
		objDTO.setId(id);
		Admin oldObj =  findById(id);
		validaPorUsuario(objDTO);
		oldObj = new Admin(objDTO);
		return repository.save(oldObj);
	}

	private void validaPorUsuario(AdminDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByUsuario(objDTO.getUsuario()); 
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Usuário já cadastrado!");
		}
	}

	
}
