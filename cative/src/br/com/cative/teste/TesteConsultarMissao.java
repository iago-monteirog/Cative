package br.com.cative.teste;

import java.sql.Connection;
import java.util.List;

import br.com.cative.beans.Missao;
import br.com.cative.beans.Usuario;
import br.com.cative.dao.MissaoDAO;

public class TesteConsultarMissao {

	public static void main(String[] args) {
		MissaoDAO missaoDAO = null;
		
		try {
			Usuario usu = new Usuario();
			usu.setIdUsuario(62);
			missaoDAO = new MissaoDAO();
			
			List<Missao> missoes = missaoDAO.getMissoes(usu.getIdUsuario());
			
			for(Missao m: missoes) {
				System.out.println(m.getObjetivo());
			}
				
			// System.out.println("Conectou");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				missaoDAO.fechar();
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}

}
