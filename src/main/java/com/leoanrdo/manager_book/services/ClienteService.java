package com.leoanrdo.manager_book.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Cliente;
import com.leoanrdo.manager_book.domain.Pessoa;
import com.leoanrdo.manager_book.domain.dtos.ClienteDTO;
import com.leoanrdo.manager_book.repositories.ClienteRepository;
import com.leoanrdo.manager_book.repositories.PessoaRepository;
import com.leoanrdo.manager_book.services.exceptions.DataIntegrityViolationException;
import com.leoanrdo.manager_book.services.exceptions.ObjectnotFoundExceptions;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundExceptions("Não encontrado! ID: " + id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorUsuario(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorUsuario(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if (obj.getLivros().size() > 0) {
			throw new DataIntegrityViolationException("O Cliente possui livros e não pode ser deletado!");
		}
		repository.deleteById(id);

	}

	private void validaPorUsuario(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByUsuario(objDTO.getUsuario());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Usuário já cadastrado!");
		}
	}

}
