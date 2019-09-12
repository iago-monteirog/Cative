package br.com.cative.beans;

public class Missao {
	private String nome;

	public Missao(String nome) {
		super();
		this.nome = nome;
	}

	public Missao() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
