package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cative.beans.Turma;
import br.com.cative.conexao.Conexao;

public class TurmaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;


	public	TurmaDAO() throws Exception {
		con = Conexao.getConexao();
		}
	
	public int addTurma(Turma t) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_TURMA(ID_TURMA, NOME_TURMA, COR_TURMA) VALUES(? , ?, ?)");
		stmt.setInt(1, t.getIdTurma());
		stmt.setString(2, t.getNomeTurma());
		stmt.setString(3, t.getCorTurma());
		return stmt.executeUpdate();
	}
	
	public Turma getTurma(int idTurma) throws Exception{
		stmt = con.prepareStatement
				("select * from TB_TURMA where ID_TURMA=?");
		stmt.setInt(1, idTurma);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Turma(
					);
		}else {
			return new Turma();
		}
	}
	
	public int kill(int idTurma) throws Exception {
		stmt = con.prepareStatement
				("delete from TB_TURMA where ID_TURMA=?");
		stmt.setInt(1, idTurma);
		return stmt.executeUpdate();
	}
}
