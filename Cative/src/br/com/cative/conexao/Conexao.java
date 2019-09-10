package br.com.cative.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConexao() throws Exception{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/cative","root","");
	} catch(ClassNotFoundException e) {
		throw new SQLException(e.getException());
	}
	}
}
	

