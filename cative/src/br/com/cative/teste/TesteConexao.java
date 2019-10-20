package br.com.cative.teste;

import java.sql.SQLException;

import br.com.cative.dao.*;


public class TesteConexao {
	public static void main(String[] args) throws SQLException { 
		try {
			UsuarioDAO dao = new UsuarioDAO();
			System.out.println("Conectou?");
		} catch(Exception e) {
			System.out.println("Conectou n");
			e.printStackTrace();
		}
	}
}
