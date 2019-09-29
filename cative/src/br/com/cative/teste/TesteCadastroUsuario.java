package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Usuario;
import br.com.cative.dao.UsuarioDAO;

public class TesteCadastroUsuario {

	public static void main(String[] args) {
		try {
			Usuario u = new Usuario();
			String[] choices = {"Aluno", "Professor", "Responsavel"};
			u.setTipoUsuario(JOptionPane.showOptionDialog(null, "Selecione seu tipo de usuario", "Tipo de usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Aluno"));
			u.setIdUsuario(2);
			u.setNome(JOptionPane.showInputDialog("Digite seu nome"));
			u.setSenha(JOptionPane.showInputDialog("Digite sua senha"));
			u.setEmail(JOptionPane.showInputDialog("Digite seu email"));
			UsuarioDAO dao = new UsuarioDAO();
			dao.addUsuarioBasic(u);
			System.out.println("Usuario cadastrado com sucesso");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
