package com.leoanrdo.manager_book.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.Cliente;
import com.leoanrdo.manager_book.domain.Livro;
import com.leoanrdo.manager_book.domain.enums.Perfil;
import com.leoanrdo.manager_book.repositories.LivroRepository;
import com.leoanrdo.manager_book.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instaciaDB() {
		Admin adm1 = new Admin(null, "Adm1", "adm1", encoder.encode("123"));
		adm1.addPerfil(Perfil.ADMIN);
		Admin adm2 = new Admin(null, "Richard", "adm2", encoder.encode("123"));
		Admin adm3 = new Admin(null, "Claude ", "adm3", encoder.encode("123"));
		
		Cliente cli1 = new Cliente(null, "Joao", "joao", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Maria", "maria", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Carlos", "carlos",encoder.encode("123"));		
		
		Livro liv1 = new Livro(null, "O Primeiro Livro", "Joao Autor", adm1, cli1);
		Livro liv2 = new Livro(null, "O Segundo Livro", "Maria Autora", adm2, cli2);
		Livro liv3 = new Livro(null, "O Terceiro Livro", "Carlos Autor", adm2, cli3);
//		Livro liv1 = new Livro(null, "O Primeiro Livro", "Joao Autor");
//		Livro liv2 = new Livro(null, "O Segundo Livro", "Maria Autora" );
//		Livro liv3 = new Livro(null, "O Terceiro Livro", "Carlos Autor");
		
		
//		adminRepository.saveAll(Arrays.asList(adm1));
//		clienteRepository.saveAll(Arrays.asList(cli1));
//		livroRepository.saveAll(Arrays.asList(liv1));
		pessoaRepository.saveAll(Arrays.asList(adm1, adm2, adm3, cli1, cli2, cli3));
		livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3));
	}

	
}
