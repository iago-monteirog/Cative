package br.com.cative.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.cative.dao.MissaoDAO;

public class TesteConsultarMissao {

	public static void main(String[] args) {
		Connection minhaConexao = null;
		try {
//		minhaConexao = Conexao.getConexao();
		MissaoDAO missaoDAO = new MissaoDAO();
		
		ArrayList missoes = missaoDAO.getMissoes();
		
		
		System.out.println(missoes.get(1).getObjetivo());
		System.out.println("Conectou");
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
