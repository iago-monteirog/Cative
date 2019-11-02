package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.conexao.Conexao;

/** Classe para os métodos referentes ao Usuario
 * 
 * @author Cative
 *
 */
public class UsuarioDAO {
	
		private Connection con;
		private PreparedStatement stmt;
		private ResultSet rs;
		
		/**
		 * Método para inciar uma conexão com o banco
		 * @throws Exception
		 * @author Cative
		 */
		public UsuarioDAO() throws Exception{
			con = Conexao.getConexao();
		}
		
		/**
		 * Método para <adicionar) uma tupla na tabela
		 * TB_USUARIO
		 * @param user
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public int addUsuario(Usuario user) throws Exception {
			stmt=con.prepareStatement("INSERT INTO TB_USUARIO(NOME_USUARIO, SENHA_USUARIO, EMAIL_USUARIO, TIPO_USUARIO, FOTO_USUARIO, TEMA_USUARIO) VALUE(?, ?, ?, ?, ?,?)");
			stmt.setString(1, user.getNome());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, user.getTipoUsuario());
			stmt.setString(6, user.getFoto());
			stmt.setString(7, user.getTema());
			return stmt.executeUpdate();
		}
		
		/**
		 * Método para <b>adicionar</b> usuarios com seus dados básicos que são:
		 * @param nomeUsuario - nome do usuário
		 * @param email - o e-mail do usuário
		 * @param tipoUsuario - o tipo (aluno, professor ou responsável)
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public Usuario adicionaUsuarioComDadosBasicos(String nomeUsuario, String email, int tipoUsuario) throws Exception {
			stmt = con.prepareStatement("INSERT INTO TB_USUARIO(NOME_USUARIO, EMAIL_USUARIO, TIPO_USUARIO) VALUES(?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nomeUsuario);
			stmt.setString(2, email);
			stmt.setInt(3, tipoUsuario);
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			Usuario usuario = new Usuario();

			if(rs.next()) {
				int id_usuario = rs.getInt(1);
				usuario.setIdUsuario(id_usuario);
				usuario.setNome(nomeUsuario);

				return usuario;
			} else {
				return usuario;
			}
		}
		
		/**
		 * Método para <b>selecionar</b> usuários da tabela
		 * TB_USUARIO
		 * através do
		 * @param idUsuario - identificador do usuário
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public Usuario getUsuario(int idUsuario) throws Exception{
			stmt = con.prepareStatement
					("select * from TB_USUARIO where ID_USUARIO=?");
			stmt.setInt(1, idUsuario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Usuario( rs.getInt("ID_USUARIO"), rs.getString("NOME_USUARIO"), 
									rs.getString("SENHA_USUARIO"), 
									rs.getString("EMAIL_USUARIO"), rs.getInt("TIPO_USUARIO"),
									rs.getString("FOTO_USUARIO"), rs.getString("TEMA_USUARIO"),
									rs.getInt("PONTOS_USUARIO"));
			} else {
				return new Usuario();
			}
		}
		
		/**
		 * Método para <b>selecionar<b> um usuário da tabela
		 * TB_USUARIO
		 * com base no seu
		 * @param email - e-mail do usuário
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public Usuario getUsuarioByEmail(String email) throws Exception{
			stmt = con.prepareStatement("select * from TB_USUARIO where EMAIL_USUARIO = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Usuario(rs.getInt("ID_USUARIO"), 
								   rs.getString("NOME_USUARIO"),
								   rs.getString("SENHA_USUARIO"), 
								   rs.getString("EMAIL_USUARIO"), 
								   rs.getInt("TIPO_USUARIO"),
								   rs.getString("FOTO_USUARIO"), 
								   rs.getString("TEMA_USUARIO"), 
								   rs.getInt("PONTOS_USUARIO")
								   );
			} else {
				return new Usuario();
			}
		}
		
		/**
		 * Método para <b>deletar</b> uma tupla da tabela
		 * TB_USUARIO
		 * buscando seu
		 * @param cod
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public int delete(int cod) throws Exception{
			
			stmt = con.prepareStatement
					("delete from DDD_TB_LOGIN where CD_USUARIO=?");
			stmt.setInt(1, cod);
			return stmt.executeUpdate();
		}
		
		/**
		 * Método para <b>atualizar</b> uma tupla da tabela
		 * TB_USUARIO
		 * buscando seu
		 * @param idUsuario
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public int attUsuario(int idUsuario) throws Exception {
			stmt = con.prepareStatement("update * from tb_usuario where id_usuario=?");
			stmt.setInt(1, idUsuario);
			int rs = stmt.executeUpdate();
			return rs;
		}
		
		/** 
		 * Método para <b>adicionar</b> um usuário com dados básicos
		 * @param user
		 * @throws Exception
		 * @author Cative
		 */
		public void addUsuarioBasic(Usuario user) throws Exception {
			stmt=con.prepareStatement("INSERT INTO TB_USUARIO(ID_USUARIO, NOME_USUARIO, SENHA_USUARIO, EMAIL_USUARIO, TIPO_USUARIO) VALUE(?, ?, ?, ?, ?)");
			stmt.setInt(1, user.getIdUsuario());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, user.getTipoUsuario());
			stmt.executeUpdate();
			stmt.close();
		}
		
		/**
		 * Método para <b>selecionar</b> um usuário a partir de seu e-mail "e"
		 * @param e - e-mail do usuário
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public Usuario retornaEmail(String e) throws Exception {
			stmt = con.prepareStatement
					("select email_usuario from tb_usuario where email_usuario=?");
			stmt.setString(1, e);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Usuario usu = new Usuario();
				usu.setEmail(rs.getString("email_usuario"));
				return usu;
			}else {
				return new Usuario();
			}
		}
		
		/**
		 * Método para <b>selecionar</b> um usuário pelo seu identificado atráves do seu
		 * @param e - e-mail do usuário
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public int getAluTurma(String e) throws Exception{
			stmt = con.prepareStatement
					("select ID_USUARIO, nome_usuario from TB_USUARIO where email_usuario LIKE ?");
			stmt.setString(1, "%" + e + "%");
			rs = stmt.executeQuery();
			if(rs.next()) {
				return (
						rs.getInt("ID_USUARIO")
						);
			}else {
				return rs.getInt("ID_USUARIO");
			}
		}
		
		/** 
		 * Método para <b>cadastrar</b> um usuário com os seguintes valores preenchidos
		 * @param email - e-mail do usuário
		 * @param nome - o nome do usuário
		 * @param tipoUsuario - o tipo do usuário (aluno, professor ou responsável)
		 * @param senha - a senha do usuário
		 * @param pontos 
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public int cadastraUsuario(String email, String nome, int tipoUsuario, String senha, int pontos) throws Exception {
			stmt = con.prepareStatement("INSERT INTO TB_USUARIO(EMAIL_USUARIO,NOME_USUARIO, TIPO_USUARIO, SENHA_USUARIO, PONTOS_USUARIO) VALUES(?,?,?,?,?)");
			stmt.setString(1, email);
			stmt.setString(2, nome);
			stmt.setInt(3, tipoUsuario);
			stmt.setString(4, senha);
			stmt.setInt(5, pontos);
			return stmt.executeUpdate();
		}
		
		/**
		 * Método para <b>selecionar</b> a quantidade de missões que o usuário concluiu
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public int getQuantidadeMissoesConcluidas() throws Exception {
			stmt = con.prepareStatement("SELECT COUNT(*) FROM TB_MISSAO");
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("COUNT(*)");				
			} else {
				return 0;
			}
		}
		
		/**
		 * Método para <b>atualizar</b> os dados do perfil já criado do usuário
		 * @param usuario
		 * @throws Exception
		 * @author Cative
		 */
		public void atualizaPerfil(Usuario usuario) throws Exception {
			stmt = con.prepareStatement
			("UPDATE TB_USUARIO SET "
			+ "NOME_USUARIO = ?, EMAIL_USUARIO = ?, SENHA_USUARIO = ?, TEMA_USUARIO = ?, FOTO_USUARIO = ? "
			+ "WHERE ID_USUARIO = ?");
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setString(5, usuario.getTema());
			stmt.setString(6, usuario.getFoto());
			stmt.setInt(7, usuario.getIdUsuario());
			
			stmt.executeUpdate();
		}
		
		/**
		 * Método que <b>seleciona</b> os alunos de uma certa turma atráves do seu identificador
		 * @param id 
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public List getAlunosTurma(int id) throws Exception {
			stmt = con.prepareStatement("select * from tb_usuario as u join tb_usuario_has_tb_turma as tu on u.id_usuario = tu.tb_usuario_id_usuario where tb_turma_id_turma=? and (tipo_usuario = 2);");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			List<Usuario> aluno = new ArrayList<Usuario>();
			while(rs.next()) {
				aluno.add(new Usuario(
						rs.getInt("ID_USUARIO"),
						rs.getString("NOME_USUARIO"),
						rs.getString("senha_USUARIO"),
						rs.getString("EMAIL_USUARIO"),
						rs.getInt("TIPO_USUARIO"),
						rs.getString("FOTO_USUARIO"),
						rs.getString("TEMA_USUARIO"),
						rs.getInt("PONTOS_USUARIO")
						));
			} return aluno;
		}
		
		/**
		 * Método para <b>validar</b> se o usuário já possue um cadastro no nosso sistema
		 * @param usuario
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public Usuario validaUsuario(Usuario usuario) throws Exception {
				Usuario usuRetorno = null;
				String sql = "select * from tb_usuario where email_usuario=? and senha_usuario=?";
				try {
					stmt = con.prepareStatement(sql);
					stmt.setString(1, usuario.getEmail());
					stmt.setString(2, usuario.getSenha());
					rs = stmt.executeQuery();
					if(rs.next()) {
						usuRetorno = new Usuario();
						usuRetorno.setIdUsuario(rs.getInt("id_usuario"));
						usuRetorno.setNome(rs.getString("nome_usuario"));
						usuRetorno.setEmail(rs.getString("email_usuario"));
						usuRetorno.setSenha(rs.getString("senha_usuario"));
						usuRetorno.setTema(rs.getString("tema_usuario"));
						usuRetorno.setFoto(rs.getString("foto_usuario"));
						usuRetorno.setTipoUsuario(rs.getInt("tipo_usuario"));
						usuRetorno.setPontuacao(rs.getInt("pontos_usuario"));
					}
				} catch(SQLException e) {
					e.printStackTrace();
					e.getMessage();
				}
				return usuRetorno;
		}
		
		/**
		 * Método para <b>adicionar</b> um aluno à turma especificada
		 * @param usuario
		 * @return
		 * @throws Exception
		 * @author Cative
		 */
		public Usuario addUsuTurma(Usuario usuario) throws Exception  {
			stmt = con.prepareStatement("INSERT INTO TB_USUARIO(NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, TIPO_USUARIO) VALUES(?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getTipoUsuario());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int id_usuario = rs.getInt(1);
				usuario.setIdUsuario(id_usuario);
				return usuario;
			} else {
				return usuario;
			}
		}
		
		public int getUsuarioByIdTurma(int idTurma) throws Exception{
			stmt = con.prepareStatement("select id_usuario from tb_usuario as u join tb_usuario_has_tb_turma as tt on u.id_usuario = tt.tb_usuario_id_usuario join tb_turma as t on t.id_turma = tt.tb_turma_id_turma where id_turma=? and (tipo_usuario=2);");
			stmt.setInt(1, idTurma);
			rs = stmt.executeQuery();
			while(rs.next()) {
				return rs.getInt("id_usuario");
			}
				return rs.getInt("id_usuario");
			}
		
		/**
		 * Método para fechar a conexão com o banco 
		 * @throws Exception
		 * @author Cative
		 */
		public void fechar() throws Exception{
			con.close();
		}
		
	}
	

