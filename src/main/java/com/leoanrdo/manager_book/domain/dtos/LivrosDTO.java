package com.leoanrdo.manager_book.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leoanrdo.manager_book.domain.Livro;

public class LivrosDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O campo TITULO é requerido")
	private String titulo;
	@NotNull(message = "O campo AUTOR é requerido")
	private String autor;

	@JsonFormat(pattern = "dd/mm/yyyy")
	private LocalDate dataCriacao = LocalDate.now();
	@JsonFormat(pattern = "dd/mm/yyyy")
	private LocalDate dataExclusao;

//	private Integer admin;
//	private Integer cliente;
//
//	private String nomeAdmin;
//	private String nomeCliente;

	public LivrosDTO() {
		super();
	}

	public LivrosDTO(Livro obj) {
		// super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.autor = obj.getAutor();
		this.dataCriacao = obj.getDataCriacao();
		this.dataExclusao = obj.getDataExclusao();
//		this.admin = obj.getAdmin().getId();
//		this.cliente = obj.getCliente().getId();
//		this.nomeAdmin = obj.getAdmin().getNome();
//		this.nomeCliente = obj.getCliente().getNome();
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

//	public Integer getAdmin() {
//		return admin;
//	}

//	public void setAdmin(Integer admin) {
//		this.admin = admin;
//	}
//
//	public Integer getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Integer cliente) {
//		this.cliente = cliente;
//	}
//
//	public String getNomeAdmin() {
//		return nomeAdmin;
//	}
//
//	public void setNomeAdmin(String nomeAdmin) {
//		this.nomeAdmin = nomeAdmin;
//	}
//
//	public String getNomeCliente() {
//		return nomeCliente;
//	}
//
//	public void setNomeCliente(String nomeCliente) {
//		this.nomeCliente = nomeCliente;
//	}

}
