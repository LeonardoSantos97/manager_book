package com.leoanrdo.manager_book.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
	
	private List<Livro> livros = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String usuario, String senha) {
		super(id, nome, usuario, senha);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	
	
}
