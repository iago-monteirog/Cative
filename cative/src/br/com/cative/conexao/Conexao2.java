package br.com.cative.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Conexao2 {

	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection
					("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM83888","fiap");
			PreparedStatement stmt = c.prepareStatement
					("select * from USUARIO where NOME_USUARIO =? AND SENHA_USUARIO =?");
			
			String login = JOptionPane .showInputDialog("Digite o login");
			String senha = JOptionPane.showInputDialog("Digite a senha");
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery
			();
			
			if(rs.next()) {
				System.out.println("Logado com sucesso");
			}else {
				System.out.println("Acesso nao permitido");
			}
			
			System.out.println("Abriu");
			}
		
			catch(Exception e){
				e.getStackTrace();
			}

	}

}
