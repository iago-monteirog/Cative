package br.com.cative.bo;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;

public class TurmaBO {
	public boolean novaTurma(Turma t) throws Exception{
		if (t.getNomeTurma().length() < 5 || t.getNomeTurma().length() > 15) {
			System.out.println("Nome da turma inválido!");
			return false;
		}
		
		TurmaDAO dao = new TurmaDAO();
		dao.addTurma(t);
		System.out.println("Turma cadastrada!");
		return true;
	}
}
