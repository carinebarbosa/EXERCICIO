package br.senai.sc.ti2013n.pw.di.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Pessoa {
	// Cadastro Cliente
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 30, nullable = false)
	private String nome;
	@Column(length = 30, nullable = false)
	private String sobreNome;
	@Column(length = 30, nullable = false)
	private String eMail;
	@Column(length = 15, nullable = false)
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
