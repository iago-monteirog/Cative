package br.com.cative.bo;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;

public class TurmaBO {
	public String novaTurma(Turma t) throws Exception{
		if (t.getNomeTurma().length() > 10) {
			return "Nome da turma inválido!";
		}
		
		TurmaDAO dao = new TurmaDAO();
		Turma turma = dao.getTurma(t.getIdTurma());
		if(turma.getIdTurma() == 0) {
			return dao.addTurma(turma) + "Turma cadastrada!";
		}else {
			return "Turma já cadastrada!";
		}
	}
}
