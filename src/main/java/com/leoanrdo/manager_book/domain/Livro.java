package com.leoanrdo.manager_book.domain;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.type.LocalDateTimeType;

public class Livro {
	
	private Integer id;
	private String titulo;
	private String autor;
	private LocalDate dataCriacao = LocalDate.now();
	private LocalDate dataExclusao;
	
	private Admin admin;
	private Cliente cliente;
	public Livro() {
		super();
	}
	public Livro(Integer id, String titulo, String autor, Admin admin, Cliente cliente) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.admin = admin;
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataExclusao() {
		return dataExclusao;
	}
	public void setDataExclusao(LocalDate dataExclusao) {
		this.dataExclusao = dataExclusao;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
