package br.com.cative.teste;

import java.sql.Connection;

import br.com.cative.conexao.Conexao;
import br.com.cative.dao.MissaoDAO;

public class TesteConsultarMissao {

	public static void main(String[] args) {
		Connection minhaConexao = null;
		try {
//		minhaConexao = Conexao.getConexao();
		MissaoDAO missaoDAO = new MissaoDAO();
		
		missaoDAO.getObjetivoMissao(1);
		
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
