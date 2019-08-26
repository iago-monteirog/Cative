package br.com.cative.conexao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public static Connection getConexao() throws Exception{
			return DriverManager.getConnection
					("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM83888","fiap");
	}
	
	}
	

