package br.com.cative.bo;

import br.com.cative.beans.Missao;
import br.com.cative.dao.MissaoDAO;
import br.com.cative.dao.TurmaDAO;

/**
 * Classe para validar as regras de negócio das missões
 * @author Cative
 *
 */
public class MissaoBO {
	
	/**
	 * Método para <b>validar</b> a quantidade de caracteres do objetivo e descrição da missao
	 * @param m
	 * @return
	 * @throws Exception
	 * @author Cative
	 */
	public boolean novaMissao(Missao m) throws Exception {
		if (m.getObjetivo().length() > 30) {
			System.out.println("Objetivo da missão inválido!");
			return false;
		}
		
		if(m.getDescricao().length() > 100) {
			System.out.println("Descrição da missão inválida!");
			return false;
		}
		
		MissaoDAO dao = new MissaoDAO();
		dao.AddMissaoBasic(m);
		System.out.println("Missão cadastrada!");
		return true;
	}
}
