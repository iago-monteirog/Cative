package br.com.cative.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConexao() throws Exception{
		return DriverManager.getConnection("jdbc:oracle:thin:1521","rm83888","fiap");
	}
	/*try {
		// Class.forName("com.mysql.jdbc.Driver");
		// return DriverManager.getConnection("jdbc:mysql://localhost/db_cative","root","");
		return DriverManager.getConnection("jdbc:oracle:thin:1521","rm83888","fiap");
	} catch(ClassNotFoundException e) {
		throw new SQLException(e.getException());
	}
	} */
}
	

