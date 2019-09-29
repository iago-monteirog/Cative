package br.com.cative.teste;

import java.sql.Connection;
import java.util.List;

import br.com.cative.beans.Missao;
import br.com.cative.dao.MissaoDAO;

public class TesteConsultarMissao {

	public static void main(String[] args) {
		Connection minhaConexao = null;
		try {
//		minhaConexao = Conexao.getConexao();
		MissaoDAO missaoDAO = new MissaoDAO();
		
		List<Missao> missoes = missaoDAO.getMissoes();
		
		for(Missao m: missoes) {
			System.out.println(m.getObjetivo());
		}
			
		// System.out.println("Conectou");
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
			minhaConexao.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}

}
