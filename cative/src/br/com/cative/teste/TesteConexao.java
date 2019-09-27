package br.com.cative.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TesteConexao {
	public static void main(String[] args) throws SQLException { 
		try {
			Connection connection = null;
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			connection = DriverManager.getConnection(url , "rm83888" , "fiap");
			System.out.println("Abriu a conexão");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from MISSÃO");
			while(rs.next()) {
				System.out.println(rs.getString("ID_MISSAO"));
				System.out.println(rs.getString("OBJETIVO"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
