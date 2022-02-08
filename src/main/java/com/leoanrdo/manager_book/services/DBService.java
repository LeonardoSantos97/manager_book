package com.leoanrdo.manager_book.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.Cliente;
import com.leoanrdo.manager_book.domain.Livro;
import com.leoanrdo.manager_book.domain.enums.Perfil;
import com.leoanrdo.manager_book.repositories.AdminRepository;
import com.leoanrdo.manager_book.repositories.ClienteRepository;
import com.leoanrdo.manager_book.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instaciaDB() {
		Admin adm1 = new Admin(null, "Adm1", "Adm1", "123");
		adm1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Joao", "joao", "123");
		
		Livro liv1 = new Livro(null, "O Melhor Livro", "Carlos Autor", adm1, cli1);
		
		adminRepository.saveAll(Arrays.asList(adm1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		livroRepository.saveAll(Arrays.asList(liv1));
	}
	
	
}
