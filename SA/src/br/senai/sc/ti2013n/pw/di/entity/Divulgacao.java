package br.senai.sc.ti2013n.pw.di.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Divulgacao {
	// Cadastro da Publicações
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 50, nullable = false)
	private String nomeDivulgacao;
	@Column(length = 500, nullable = false)
	private String descricaoDivulgacao;
	@Column(length = 30)
	private String siteDivulgacao;
	@Column(length = 100)
	private String localDivulgacao;
	@Column(length = 15)
	private String telefoneDivulgacao;
	@Column(length = 30)
	private String categoriaDivulgacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDivulgacao() {
		return nomeDivulgacao;
	}

	public void setNomeDivulgacao(String nomeDivulgacao) {
		this.nomeDivulgacao = nomeDivulgacao;
	}

	public String getDescricaoDivulgacao() {
		return descricaoDivulgacao;
	}

	public void setDescricaoDivulgacao(String descricaoDivulgacao) {
		this.descricaoDivulgacao = descricaoDivulgacao;
	}

	public String getSiteDivulgacao() {
		return siteDivulgacao;
	}

	public void setSiteDivulgacao(String siteDivulgacao) {
		this.siteDivulgacao = siteDivulgacao;
	}

	public String getLocalDivulgacao() {
		return localDivulgacao;
	}

	public void setLocalDivulgacao(String localDivulgacao) {
		this.localDivulgacao = localDivulgacao;
	}

	public String getTelefoneDivulgacao() {
		return telefoneDivulgacao;
	}

	public void setTelefoneDivulgacao(String telefoneDivulgacao) {
		this.telefoneDivulgacao = telefoneDivulgacao;
	}

	public String getCategoriaDivulgacao() {
		return categoriaDivulgacao;
	}

	public void setCategoriaDivulgacao(String categoriaDivulgacao) {
		this.categoriaDivulgacao = categoriaDivulgacao;
	}

}
