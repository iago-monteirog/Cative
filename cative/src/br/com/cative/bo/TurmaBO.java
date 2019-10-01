package br.com.cative.bo;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;

public class TurmaBO {
	public boolean novaTurma(Turma t) throws Exception{
		if (t.getNomeTurma().length() > 10) {
			System.out.println("Nome da turma inválido!");
			return false;
		}
		
		TurmaDAO dao = new TurmaDAO();
		Turma turma = dao.getTurma(t.getIdTurma());
		if(turma.getIdTurma() == 0) {
			System.out.println(dao.addTurma(turma) + "Turma cadastrada!");
			return true;
		}else {
			System.out.println("Turma já cadastrada!");
			return false;
		}
	}
}
