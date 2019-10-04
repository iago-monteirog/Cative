package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cative.beans.Turma;
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
			stmt=con.prepareStatement("INSERT INTO TB_USUARIO(ID_USUARIO, NOME_USUARIO, SOBRENOME_USUARIO, SENHA_USUARIO, EMAIL_USUARIO, TIPO_USUARIO, FOTO_USUARIO, TEMA_USUARIO) VALUE(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, user.getIdUsuario());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getSobrenome());
			stmt.setString(4, user.getSenha());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getTipoUsuario());
			stmt.setString(7, user.getFoto());
			stmt.setString(8, user.getTema());
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
		
		public Usuario getUsuario(int cod) throws Exception{
			stmt = con.prepareStatement
					("select * from USUARIO where NOME_USUARIO=?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Usuario(
						);
			}else {
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
		
		public int getAluTurma(String u) throws Exception{
			stmt = con.prepareStatement
					("select ID_USUARIO from TB_USUARIO where NOME_USUARIO LIKE ?");
			stmt.setString(1, "%" + u + "%");
			rs = stmt.executeQuery();
			if(rs.next()) {
				return (
						rs.getInt("ID_USUARIO")
						);
			}else {
				return rs.getInt("ID_USUARIO");
			}
		}
		
		public void fechar() throws Exception{
			con.close();
		}
		
	}
	

