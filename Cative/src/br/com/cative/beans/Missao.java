package br.com.cative.beans;

public class Missao {
	private String idMissao;
	private String objetivo;
	private String descricao;
	private String dtInicio;
	private String dtFinal;
	private String ciclo;
	private String imgMissao;
	private String tempoDuracao;
	
	public String getTudo() {
		return "id Missão" + "\n" + 
				"Objetivo" + "\n" +
				"Descrição" + "\n" +
				"Data inicio" + "\n" +
				"Data final" + "\n" + 
				"Ciclo" + "\n" +
				"Imagem da missão" + "\n" +
				"Tempo de duração" + "\n";
	}
	
	public void setTudo(String im, String o, String d, String di, String df, String c, String img, String td) {
		this.idMissao=im;
		this.objetivo=o;
		this.descricao=d;
		this.dtInicio=di;
		this.dtFinal=df;
		this.ciclo=c;
		this.imgMissao=img;
		this.tempoDuracao=td;
	}
	
	public Missao() {
		super();
	}

	public Missao(String idMissao, String objetivo, String descricao, String dtInicio, String dtFinal, String ciclo,
			String imgMissao, String tempoDuracao) {
		super();
		this.idMissao = idMissao;
		this.objetivo = objetivo;
		this.descricao = descricao;
		this.dtInicio = dtInicio;
		this.dtFinal = dtFinal;
		this.ciclo = ciclo;
		this.imgMissao = imgMissao;
		this.tempoDuracao = tempoDuracao;
	}
	
	public String getIdMissao() {
		return idMissao;
	}
	public void setIdMissao(String idMissao) {
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
	
}
