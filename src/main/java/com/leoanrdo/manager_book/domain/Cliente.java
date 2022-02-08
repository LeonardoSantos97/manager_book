package com.leoanrdo.manager_book.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.leoanrdo.manager_book.domain.enums.Perfil;


@Entity
public class Cliente extends Pessoa{
	
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	private List<Livro> livros = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String usuario, String senha) {
		super(id, nome, usuario, senha);
		addPerfil(Perfil.CLIENTE);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	
	
}
