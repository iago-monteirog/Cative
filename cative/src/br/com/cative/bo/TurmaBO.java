package br.com.cative.bo;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;
import br.com.cative.dao.UsuarioDAO;

/**
 * Classe para validar as regras de negócio
 * @author Cative
 *
 */
public class TurmaBO {
	
	/**
	 * Método para <b>validar</b> a quantidade de caracteres do nome da missão
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public boolean verificaTurma(Turma t) throws Exception{
		TurmaDAO dao = new TurmaDAO();
		if (t.getNomeTurma().length() < 5 || t.getNomeTurma().length() > 15) {
			System.out.println("Nome da turma inválido!");
			return false;
		}
		dao.addTurma(t.getNomeTurma());
		System.out.println("Turma cadastrada!");
		return true;
		}
	
		
		
	
}
