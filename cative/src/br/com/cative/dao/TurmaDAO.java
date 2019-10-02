package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cative.beans.Turma;
import br.com.cative.conexao.Conexao;

public class TurmaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;


	public	TurmaDAO() throws Exception {
		con = Conexao.getConexao();
		}
	
	public void addAluno(int u, int t, String nu, String nt) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_USUARIO_has_TB_TURMA(TB_USUARIO_id_usuario, TB_TURMA_id_turma, nome_usuario, nome_turma) VALUES(?, ?, ?, ?)");
		stmt.setInt(1, u);
		stmt.setInt(2, t);
		stmt.setString(3, nu);
		stmt.setString(4, nt);
		stmt.execute();
		stmt.close();
	}
	
	public int addTurma(Turma t) throws Exception {
		
		System.out.println("Turma: "+t.getNomeTurma());
		
		stmt = con.prepareStatement("INSERT INTO TB_TURMA(NOME_TURMA) VALUES(?)");
		stmt.setString(1, t.getNomeTurma());
		
		return stmt.executeUpdate();
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
	
	public List getTurmaAluno() throws Exception {
		stmt = con.prepareStatement("SELECT NOME_TURMA FROM TB_TURMA");
		rs = stmt.executeQuery();
		List<Turma> turmas = new ArrayList<Turma>();
		while(rs.next()) {
			turmas.add(new Turma(rs.getString("NOME_TURMA")));
		}
		return turmas;
	}
	
	public int getTurmaAlu(String n) throws Exception{
		stmt = con.prepareStatement
				("select ID_TURMA from TB_TURMA where NOME_TURMA LIKE ?");
		stmt.setString(1, "%" + n + "%");
		rs = stmt.executeQuery();
		if(rs.next()) {
			return(
					rs.getInt("ID_TURMA")
					);
		}else {
			return rs.getInt("ID_TURMA");
		}
	}
	

	public void fechar() throws Exception{
		con.close();
	}

}
