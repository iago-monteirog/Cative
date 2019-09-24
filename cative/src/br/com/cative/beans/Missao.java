package br.com.cative.beans;

public class Missao {
	private int idMissao;
	private String objetivo;
	private String descricao;
	private String dtInicio;
	private String dtFinal;
	private String ciclo;
	private String imgMissao;
	private String tempoDuracao;
	private int pontos;
	
	public Missao() {
		super();
	}
	
	public Missao(int idMissao, String objetivo, String descricao, String imgMissao, int pontos) {
		super();
		this.idMissao = idMissao;
		this.objetivo = objetivo;
		this.descricao = descricao;
		this.imgMissao = imgMissao;
		this.pontos = pontos;
	}

	public Missao(int idMissao, String objetivo, String descricao, String dtInicio, String dtFinal, String ciclo,
			String imgMissao, String tempoDuracao, int pontos) {
		super();
		this.idMissao = idMissao;
		this.objetivo = objetivo;
		this.descricao = descricao;
		this.dtInicio = dtInicio;
		this.dtFinal = dtFinal;
		this.ciclo = ciclo;
		this.imgMissao = imgMissao;
		this.tempoDuracao = tempoDuracao;
		this.pontos = pontos;
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
	public String getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(String dtFinal) {
		this.dtFinal = dtFinal;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getImgMissao() {
		return imgMissao;
	}
	public void setImgMissao(String imgMissao) {
		this.imgMissao = imgMissao;
	}
	public String getTempoDuracao() {
		return tempoDuracao;
	}
	public void setTempoDuracao(String tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
}
