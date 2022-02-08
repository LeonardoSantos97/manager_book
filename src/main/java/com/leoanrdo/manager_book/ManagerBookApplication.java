package com.leoanrdo.manager_book;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.Cliente;
import com.leoanrdo.manager_book.domain.Livro;
import com.leoanrdo.manager_book.domain.enums.Perfil;
import com.leoanrdo.manager_book.repositories.AdminRepository;
import com.leoanrdo.manager_book.repositories.ClienteRepository;
import com.leoanrdo.manager_book.repositories.LivroRepository;

@SpringBootApplication
public class ManagerBookApplication implements CommandLineRunner{

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ManagerBookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin adm1 = new Admin(null, "Adm1", "Adm1", "123");
		adm1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Joao", "joao", "123");
		
		Livro liv1 = new Livro(null, "O Melhor Livro", "Carlos Autor", adm1, cli1);
		
		adminRepository.saveAll(Arrays.asList(adm1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		livroRepository.saveAll(Arrays.asList(liv1));
		
	}

}
