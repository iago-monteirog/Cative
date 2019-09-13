package br.com.cative.teste;

import java.sql.Connection;

import br.com.cative.conexao.Conexao;

public class TesteConsultarUsuario {

	public static void main(String[] args) {
		Connection minhaConexao = null;
		try {
		minhaConexao = Conexao.getConexao();
		
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
