package br.com.cative.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;

public class TesteAluno {
	public static void main(String[] args) throws Exception {
		TurmaDAO turmadao = new TurmaDAO();
		List<Turma> turmas = turmadao.getListTurmas();
		for(Turma turma : turmas) {
			System.out.println(turma.getNomeTurma());
			System.out.println(turma.getIdTurma());
		}
	}
}
