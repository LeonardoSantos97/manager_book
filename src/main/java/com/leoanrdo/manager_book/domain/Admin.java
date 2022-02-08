package com.leoanrdo.manager_book.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leoanrdo.manager_book.domain.dtos.AdminDTO;
import com.leoanrdo.manager_book.domain.enums.Perfil;

@Entity
public class Admin extends Pessoa{

	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	private List<Livro> livros = new ArrayList<>();

	public Admin() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Admin(Integer id, String nome, String usuario, String senha) {
		super(id, nome, usuario, senha);
		addPerfil(Perfil.CLIENTE);
	}
	
	public Admin(AdminDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.usuario = obj.getUsuario();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getId()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
	
	
	
}
