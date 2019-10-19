package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cative.beans.Turma;
import br.com.cative.conexao.Conexao;

public class TurmaDAO {
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;


	public	TurmaDAO() throws Exception {
		con = Conexao.getConexao();
		}
	
	public int adicionaAlunoEmTurma(int idUsuario, int idTurma) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_USUARIO_has_TB_TURMA(TB_USUARIO_id_usuario, TB_TURMA_id_turma) VALUES(?, ?)");
		stmt.setInt(1, idUsuario);
		stmt.setInt(2, idTurma);
		return stmt.executeUpdate();
	}
	
	public Turma addTurma(String nomeTurma) throws Exception {
				
		stmt = con.prepareStatement("INSERT INTO TB_TURMA(NOME_TURMA) VALUES(?)",PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, nomeTurma);
		stmt.executeUpdate();
		
		rs = stmt.getGeneratedKeys();

		Turma turma = new Turma();
		if(rs.next()) {
			int id_turma = rs.getInt(1);
			turma.setIdTurma(id_turma);
			turma.setNomeTurma(nomeTurma);

			return turma;
		} else {
			return turma;
		}
	}
	
	public List getListTurmas() throws Exception {
		stmt = con.prepareStatement("select * from tb_turma");
		rs = stmt.executeQuery();
		List<Turma> turmas = new ArrayList<Turma>();
		while(rs.next()) {
			turmas.add(new Turma(
					rs.getInt("ID_TURMA"),
					rs.getString("NOME_TURMA"), 
					rs.getString("COR_TURMA")));
		}
			return turmas;
		}
	
	public Turma getTurma(int idTurma) throws Exception{
		stmt = con.prepareStatement
				("select * from TB_TURMA where ID_TURMA=?");
		stmt.setInt(1, idTurma);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Turma(
					rs.getInt("ID_TURMA"),
					rs.getString("NOME_TURMA"),
					rs.getString("COR_TURMA")
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
	
	public int attTurma(int idTurma) throws Exception {
		stmt = con.prepareStatement("update * from tb_turma where id_turma=?");
		stmt.setInt(1, idTurma);
		int rs = stmt.executeUpdate();
		return rs;
	}
	
	public int getTurmaAlu(int i) throws Exception{
		stmt = con.prepareStatement ("insert into tb_turma (id_turma) values(?)",PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, i);
		stmt.executeUpdate();
		rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int id_turma = 0;
				id_turma = rs.getInt(1);
				return id_turma;
			} else {
				int id_turma = 0;
				return id_turma;
			}
	
		}
		

	public void fechar() throws Exception{
		con.close();
	}

}
