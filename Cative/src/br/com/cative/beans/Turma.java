package br.com.cative.beans;

public class Turma {
	private String idTurma;
	private String nomeTurma;
	private String corTurma;
	
	public String getTudo() {
		return "ID Turma " + "\n" +
				"Nome da turma:" + "\n" +
				"Cor da turma:" + "\n";
	}
	
	public void setTudo(String it, String nt, String ct) {
		this.idTurma = it;
		this.nomeTurma = nt;
		this.corTurma = ct;
	}
	
	public Turma() {
		super();
	}
	
	public Turma(String idTurma, String nomeTurma, String corTurma) {
		super();
		this.idTurma = idTurma;
		this.nomeTurma = nomeTurma;
		this.corTurma = corTurma;
	}
	
	public String getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(String idTurma) {
		this.idTurma = idTurma;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public String getCorTurma() {
		return corTurma;
	}
	public void setCorTurma(String corTurma) {
		this.corTurma = corTurma;
	}
	
	
}
