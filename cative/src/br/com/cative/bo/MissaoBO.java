package br.com.cative.bo;

import br.com.cative.beans.Missao;
import br.com.cative.dao.MissaoDAO;
import br.com.cative.dao.TurmaDAO;

public class MissaoBO {
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
