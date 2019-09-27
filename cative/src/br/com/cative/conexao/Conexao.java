package br.com.cative.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConexao() throws Exception{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/db_cative","root","");
	} catch(ClassNotFoundException e) {
		throw new SQLException(e.getException());
	}
	}
	
	public static Connection getConexaoORCL() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL" , "rm83888" , "fiap");
	}
}
	

