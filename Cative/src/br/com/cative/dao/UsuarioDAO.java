package br.com.cative.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			stmt.setString(6, user.getTipoUsuario());
			stmt.setString(7, user.getFoto());
			stmt.setString(8, user.getTema());
			return stmt.executeUpdate();
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
		
		public void fechar() throws Exception{
			con.close();
		}
		
	}
	

