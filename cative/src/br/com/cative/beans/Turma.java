package br.com.cative.beans;

public class Turma {
	private int idTurma;
	private String nomeTurma;
	private String corTurma;
	
	public Turma() {
		super();
	}
	public Turma(int idTurma, String nomeTurma, String corTurma) {
		super();
		this.idTurma = idTurma;
		this.nomeTurma = nomeTurma;
		this.corTurma = corTurma;
	}
	
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
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
