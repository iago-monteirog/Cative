package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cative.beans.Missao;
import br.com.cative.conexao.Conexao;

public class MissaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;


	public	MissaoDAO() throws Exception {
		con = Conexao.getConexao();
		}
	
	public int AddMissao(Missao m) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_MISSAO(ID_MISSAO, OBJETIVO_MISSAO, DESCRICAO_MISSAO, DT_INICIO, DT_FINAL, CICLO_MISSAO, IMAGEM_MISSAO, TEMPO_DURACAO, PONTOS_MISSAO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, m.getIdMissao());
		stmt.setString(2, m.getObjetivo());
		stmt.setString(3, m.getDescricao());
		stmt.setString(4, m.getDtInicio());
		stmt.setString(5, m.getDtFinal());
		stmt.setString(6, m.getCiclo());
		stmt.setString(7, m.getImgMissao());
		stmt.setString(8, m.getTempoDuracao());
		stmt.setInt(9, m.getPontos());
		return stmt.executeUpdate();
	}
	
	public Missao getMissao(int idMissao) throws Exception{
		stmt = con.prepareStatement
				("select * from TB_MiSSAO where ID_MISSAO=?");
		stmt.setInt(1, idMissao);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Missao(
					);
		}else {
			return new Missao();
		}
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
	
	public void fechar() throws Exception{
		con.close();
	}

}