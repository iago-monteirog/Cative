package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cative.beans.Usuario;
import br.com.cative.conexao.Conexao;

public class UsuarioDAO {
	
		private Connection con;
		private PreparedStatement stmt;
		private ResultSet rs;
		
		public UsuarioDAO() throws Exception{
			con = Conexao.getConexao();
		}
		
		
		public int addUsuario(Usuario user) throws Exception {
			stmt=con.prepareStatement("INSERT INTO TB_USUARIO(NOME_USUARIO, SOBRENOME_USUARIO, SENHA_USUARIO, EMAIL_USUARIO, TIPO_USUARIO, FOTO_USUARIO, TEMA_USUARIO) VALUE(?, ?, ?, ?, ?, ?,?)");
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getSobrenome());
			stmt.setString(3, user.getSenha());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, user.getTipoUsuario());
			stmt.setString(6, user.getFoto());
			stmt.setString(7, user.getTema());
			return stmt.executeUpdate();
		}
		
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

		public Usuario getUsuario(int idUsuario) throws Exception{
			stmt = con.prepareStatement
					("select * from TB_USUARIO where ID_USUARIO=?");
			stmt.setInt(1, idUsuario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Usuario( rs.getInt("ID_USUARIO"), rs.getString("NOME_USUARIO"), 
									rs.getString("SOBRENOME_USUARIO"), rs.getString("SENHA_USUARIO"), 
									rs.getString("EMAIL_USUARIO"), rs.getInt("TIPO_USUARIO"),
									rs.getString("FOTO_USUARIO"), rs.getString("TEMA_USUARIO"),
									rs.getInt("PONTOS_USUARIO"));
			} else {
				return new Usuario();
			}
		}
		
		public Usuario getUsuarioByEmail(String email) throws Exception{
			stmt = con.prepareStatement("select * from TB_USUARIO where EMAIL_USUARIO = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Usuario(rs.getInt("ID_USUARIO"), 
								   rs.getString("NOME_USUARIO"), 
								   rs.getString("SOBRENOME_USUARIO"), 
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
		
		public int delete(int cod) throws Exception{
			
			stmt = con.prepareStatement
					("delete from DDD_TB_LOGIN where CD_USUARIO=?");
			stmt.setInt(1, cod);
			return stmt.executeUpdate();
		}
		
		public int attUsuario(int idUsuario) throws Exception {
			stmt = con.prepareStatement("update * from tb_usuario where id_usuario=?");
			stmt.setInt(1, idUsuario);
			int rs = stmt.executeUpdate();
			return rs;
		}
		
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
		
		public int cadastraUsuario(String email, String tipoUsuario, String senha) throws Exception {
			stmt = con.prepareStatement("INSERT INTO TB_USUARIO(EMAIL_USUARIO, TIPO_USUARIO, SENHA_USUARIO) VALUES(?,?,?)");
			stmt.setString(1, email);
			stmt.setString(2, tipoUsuario);
			stmt.setString(3, senha);
			return stmt.executeUpdate();
		}
		
		public int getQuantidadeMissoesConcluidas() throws Exception {
			stmt = con.prepareStatement("SELECT COUNT(*) FROM TB_MISSAO");
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("COUNT(*)");				
			} else {
				return 0;
			}
		}
		
		public void atualizaPerfil(Usuario usuario) throws Exception {
			stmt = con.prepareStatement
			("UPDATE TB_USUARIO SET NOME_USUARIO = ?, SOBRENOME_USUARIO = ?, EMAIL_USUARIO = ?, SENHA_USUARIO = ?, TEMA_USUARIO = ?, FOTO_USUARIO = ? WHERE ID_USUARIO = 1");
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setString(5, usuario.getTema());
			stmt.setString(6, usuario.getFoto());
			
			stmt.executeUpdate();
		}
		
		public List getAlunosTurma() throws Exception {
			stmt = con.prepareStatement("select * from tb_usuario");
			rs = stmt.executeQuery();
			List<Usuario> aluno = new ArrayList<Usuario>();
			while(rs.next()) {
				aluno.add(new Usuario(
						rs.getInt("ID_USUARIO"),
						rs.getString("NOME_USUARIO"),
						rs.getString("SOBRENOME_USUARIO"),
						rs.getString("senha_USUARIO"),
						rs.getString("EMAIL_USUARIO"),
						rs.getInt("TIPO_USUARIO"),
						rs.getString("FOTO_USUARIO"),
						rs.getString("TEMA_USUARIO"),
						rs.getInt("PONTOS_USUARIO")
						));
			} return aluno;
		}
		
		public void fechar() throws Exception{
			con.close();
		}
		
	}
	

