package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.cative.beans.Missao;
import br.com.cative.conexao.Conexao;

public class MissaoDAO {
	private Connection con;
	private Connection con1;
	private PreparedStatement stmt;
	private ResultSet rs;


	public	MissaoDAO() throws Exception {
		con = Conexao.getConexao();
//		con1 = Conexao.getConexaoORCL();
		}
	
	public void AddMissaoBasic(Missao m) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_MISSAO(OBJETIVO_MISSAO, DESCRICAO_MISSAO,PONTOS_MISSAO) VALUES(?, ?, ?)");
		stmt.setString(1, m.getObjetivo());
		stmt.setString(2, m.getDescricao());
		stmt.setInt(3, m.getPontos());
		stmt.execute();
		stmt.close();
	}
	
	
	public Missao getMissao(int idMissao) throws Exception{
		stmt = con.prepareStatement
				("select ID_MISSAO, OBJETIVO_MISSAO, DESCRICAO_MISSAO, IMG_MISSAO, PONTOS_MISSAO, COR_MISSAO  from TB_MiSSAO where ID_MISSAO=?");
		stmt.setInt(1, idMissao);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Missao(
					rs.getInt("ID_MISSAO"),
					rs.getString("OBJETIVO_MISSAO"),
					rs.getString("DESCRICAO_MISSAO"),
					rs.getString("IMG_MISSAO"),
					rs.getInt("PONTOS_MISSAO"),
					rs.getString("COR_MISSAO")
					);
		}else {
			return new Missao();
		}
	}

	
	public List getMissoes() throws Exception{
		stmt = con.prepareStatement
				("SELECT * FROM TB_MISSAO ");
		rs = stmt.executeQuery();
		List<Missao> missoes = new ArrayList<Missao>();
		while(rs.next()) {
			missoes.add(
				new Missao(
						rs.getInt("ID_MISSAO"),
						rs.getString("OBJETIVO_MISSAO"),
						rs.getString("DESCRICAO_MISSAO"),
						rs.getString("IMAGEM_MISSAO"), //TODO: mudar pra IMG_MISSAO
						rs.getInt("PONTOS_MISSAO"), //TODO: mudar pra PONTOS_MISSAO
						rs.getString("COR_MISSAO") // TODO: mudar pra COR_MISSAO
					));
		}
		return missoes;
	}
	
	public int delMissao(int idMissao) throws Exception {
		stmt = con.prepareStatement
				("delete from TB_MISSAO where ID_MISSAO=?");
		stmt.setInt(1, idMissao);
		return stmt.executeUpdate();
	}
	
	public int attMissao(int idMissao) throws Exception {
		stmt = con.prepareStatement("update * from tb_missao where id_missao=?");
		stmt.setInt(1, idMissao);
		int rs = stmt.executeUpdate();
		return rs;
	}
	
	public Missao adicionaMissao(Missao missao) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_MISSAO(OBJETIVO_MISSAO, DESCRICAO_MISSAO, IMAGEM_MISSAO, PONTOS_MISSAO, COR_MISSAO) VALUES(?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, missao.getObjetivo());
		stmt.setString(2, missao.getDescricao());
		stmt.setString(3, missao.getImgMissao());
		stmt.setInt(4, missao.getPontos());
		stmt.setString(5, missao.getCorMissao());
		stmt.executeUpdate();
		rs = stmt.getGeneratedKeys();
		if(rs.next()) {
			int id_missao = rs.getInt(1);
			missao.setIdMissao(id_missao);
			return missao;
		} else {
			return missao;
		}
	}
	
	public int adicionaMissaoEmTurma(int idTurma, int idMissao) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_turma_has_TB_Missao(TB_TURMA_id_turma, TB_missao_id_missao) VALUES(?, ?)");
		stmt.setInt(1, idTurma);
		stmt.setInt(2, idMissao);
		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception{
		con.close();
	}

}