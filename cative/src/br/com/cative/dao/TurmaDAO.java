package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.conexao.Conexao;
/** Classe para os métodos referentes a Turma
 * 
 * @author Cative
 *
 */
public class TurmaDAO {
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;

	/** Método para iniciar a conexão com o banco
	 * @author Cative */
	public	TurmaDAO() throws Exception {
		con = Conexao.getConexao();
		}
	
	
	/** Método que <b>adiciona</b> uma tupla na tabela
	 *  TB_USUARIO_has_TB_TURMA
	 *  Irá adicionar um aluno em uma turma específica
	 *  @param idUsuario - identificador do usuário
	 *  @param idTurma - identificador da turma
	 *  @author Cative*/
	public int adicionaAlunoEmTurma(int idUsuario, int idTurma) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_USUARIO_has_TB_TURMA(TB_USUARIO_id_usuario, TB_TURMA_id_turma) VALUES(?, ?)");
		stmt.setInt(1, idUsuario);
		stmt.setInt(2, idTurma);
		return stmt.executeUpdate();
	}
	
	

	/** Método que <b>adiciona</b> na tabela
	 * TB_TURMA 
	 * uma turma
	 * @param nomeTurma - nome da Turma  
	 * nao havendo repetições
	 * @author Cative*/
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
	
	/** Método que <b>retorna</b> uma lista
	 * dos alunos de uma turma específica
	 * @param idUsuario - identificador do usuário
	 * @author Cative*/
	public List getListTurmas(int idUsuario) throws Exception {
		stmt = con.prepareStatement("select * from tb_turma as t join tb_usuario_has_tb_turma as tu on t.id_turma = tu.tb_turma_id_turma join tb_usuario as u on u.id_usuario = tu.tb_usuario_id_usuario where u.id_usuario = ?;");
		stmt.setInt(1, idUsuario);
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
	
	
	/** Método que <b>seleciona</b> uma tupla da tabela
	 * TB_TURMA
	 * @param idTurma - identificador da turma
	 * @author Cative */
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
	
	
	/** Método que <b>deleta<b> uma tupla da tabela
	 * TB_TURMA
	 * @author Cative */
	public int kill(int idTurma) throws Exception {
		stmt = con.prepareStatement
				("delete from TB_TURMA where ID_TURMA=?");
		stmt.setInt(1, idTurma);
		return stmt.executeUpdate();
	}
	
	
	/** Método que <b>atualiza</b> uma tupla da tabela
	 * TB_TURMA
	 * @author Cative */
	public int attTurma(int idTurma) throws Exception {
		stmt = con.prepareStatement("update * from tb_turma where id_turma=?");
		stmt.setInt(1, idTurma);
		int rs = stmt.executeUpdate();
		return rs;
	}
	
	
	/** Método para <b>validar</b>
	 * se uma turma existe atráves do
	 * @param nomeTurma - nome atribuído a turma
	 * @author Cative  */
	public Turma validaTurma(Turma turma) throws Exception {
		Turma turmaRetorno = null;
		String sql = "select * from tb_turma where nome_turma=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, turma.getNomeTurma());
			rs = stmt.executeQuery();
			if(rs.next()) {
				turmaRetorno = new Turma();
				turmaRetorno.setIdTurma(rs.getInt("id_turma"));
				turmaRetorno.setNomeTurma(rs.getString("nome_turma"));
				turmaRetorno.setCorTurma(rs.getString("cor_turma"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return turmaRetorno;
}
	
	/** 
	 * Método para <b>selecionar</b> uma turma de um certo professor
	 * @return
	 * @throws Exception
	 */
	public List getDirecMissao() throws Exception {
		Usuario usu = new Usuario();
		stmt = con.prepareStatement("select id_turma, nome_turma, cor_turma from tb_turma as t join tb_usuario_has_tb_turma as tu "
				+ "on t.id_turma = tu.tb_turma_id_turma join tb_usuario as u on u.id_usuario = tu.tb_usuario_id_usuario where u.id_usuario = ?;");
		stmt.setInt(1, usu.getIdUsuario());
		rs = stmt.executeQuery();
		List<Turma> turmaM = new ArrayList<Turma>();
		while(rs.next()) {
			turmaM.add(new Turma(
					rs.getInt("ID_TURMA"),
					rs.getString("NOME_TURMA"), 
					rs.getString("COR_TURMA")));
		}
			return turmaM;
		}	
	
	/**
	 * Método para <b>selecionar</b> uma turma através do
	 * @param id
	 * @return
	 * @throws Exception
	 * @author Cative
	 */
	public Turma getTurmaById(int id) throws Exception{
		stmt = con.prepareStatement("select * from TB_turma where id_turma = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Turma(
					rs.getInt("id_turma"), 
					rs.getString("nome_turma"), 
					rs.getString("cor_turma")
							   );
		} else {
			return new Turma();
		}
	}
	
	
	/** Método para fechar a conexão com o banco 
	 * @author Cative*/
	public void fechar() throws Exception{
		con.close();
	}

}
