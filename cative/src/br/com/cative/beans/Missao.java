package br.com.cative.beans;

public class Missao implements Comparable<Missao> {
	private int idMissao;
	private String objetivo;
	private String descricao;
	private String imgMissao;
	private int pontos;
	private String corMissao;

	/*
	public int compareTo(Missao outro) {
		if(objetivo.length() < outro.objetivo.length()) {
			return -1;
		} else if(objetivo.length() > objetivo.length()) {
			return 1;
		} else {
			return 0;
		}
	}
	*/

	public int compareTo(Missao outro) {
		return -objetivo.compareTo(outro.objetivo);
	}
 

	
	public Missao() {
		super();
	}
	
	public Missao(int pontos) {
		super();
		this.pontos = pontos;
	}

	public Missao(int idMissao, String objetivo, String descricao, String imgMissao, int pontos, String corMissao) {
		super();
		this.idMissao = idMissao;
		this.objetivo = objetivo;
		this.descricao = descricao;
		this.imgMissao = imgMissao;
		this.pontos = pontos;
		this.corMissao = corMissao;
	}


	public int getIdMissao() {
		return idMissao;
	}
	public void setIdMissao(int idMissao) {
		this.idMissao = idMissao;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImgMissao() {
		return imgMissao;
	}
	public void setImgMissao(String imgMissao) {
		this.imgMissao = imgMissao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getCorMissao() {
		return corMissao;
	}
	public void setCorMissao(String corMissao) {
		this.corMissao = corMissao;
	}
	
	
}
