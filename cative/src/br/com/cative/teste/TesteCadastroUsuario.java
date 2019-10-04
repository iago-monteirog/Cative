package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Usuario;
import br.com.cative.bo.UsuarioBO;

public class TesteCadastroUsuario {

	public static void main(String[] args) {
		try {
			Usuario usuario = new Usuario();
			String[] choices = {"Aluno", "Professor", "Responsavel"};
			usuario.setTipoUsuario(JOptionPane.showOptionDialog(null, "Selecione seu tipo de usuario", "Tipo de usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Aluno"));
			usuario.setIdUsuario(0);
			usuario.setNome(JOptionPane.showInputDialog("Digite seu nome"));
			usuario.setSenha(JOptionPane.showInputDialog("Digite sua senha"));
			usuario.setEmail(JOptionPane.showInputDialog("Digite seu email"));
			UsuarioBO bo = new UsuarioBO();
			System.out.println(bo.verificaUsuario(usuario));
		}catch(Exception e) {
			e.printStackTrace();
	}
	}
}
