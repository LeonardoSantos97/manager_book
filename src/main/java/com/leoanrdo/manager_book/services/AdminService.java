package com.leoanrdo.manager_book.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.Pessoa;
import com.leoanrdo.manager_book.domain.dtos.AdminDTO;
import com.leoanrdo.manager_book.repositories.AdminRepository;
import com.leoanrdo.manager_book.repositories.PessoaRepository;
import com.leoanrdo.manager_book.services.exceptions.DataIntegrityViolationException;
import com.leoanrdo.manager_book.services.exceptions.ObjectnotFoundExceptions;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Admin findById(Integer id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundExceptions("Não encontrado! ID: " + id));
	}

	public List<Admin> findAll() {
		return repository.findAll();
	}

	public Admin create(AdminDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorUsuario(objDTO);
		Admin newObj = new Admin(objDTO);
		return repository.save(newObj);
	}

	public Admin update(Integer id, @Valid AdminDTO objDTO) {
		objDTO.setId(id);
		Admin oldObj = findById(id);
		validaPorUsuario(objDTO);
		oldObj = new Admin(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Admin obj = findById(id);
		if (obj.getLivros().size() > 0) {
			throw new DataIntegrityViolationException("O Admin possui livros e não pode ser deletado!");
		}
		repository.deleteById(id);

	}

	private void validaPorUsuario(AdminDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByUsuario(objDTO.getUsuario());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Usuário já cadastrado!");
		}
	}

}
