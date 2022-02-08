package com.leoanrdo.manager_book.domain;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Pessoa{

	private List<Livro> livros = new ArrayList<>();

	public Admin() {
		super();
	}

	public Admin(Integer id, String nome, String usuario, String senha) {
		super(id, nome, usuario, senha);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
	
	
	
}
