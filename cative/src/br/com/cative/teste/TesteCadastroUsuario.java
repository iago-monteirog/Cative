package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Usuario;
import br.com.cative.bo.UsuarioBO;

public class TesteCadastroUsuario {

	public static void main(String[] args) {
		try {
			Usuario u = new Usuario();
			String[] choices = {"Aluno", "Professor", "Responsavel"};
			u.setTipoUsuario(JOptionPane.showOptionDialog(null, "Selecione seu tipo de usuario", "Tipo de usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Aluno"));
			u.setIdUsuario(0);
			u.setNome(JOptionPane.showInputDialog("Digite seu nome"));
			u.setSenha(JOptionPane.showInputDialog("Digite sua senha"));
			u.setEmail(JOptionPane.showInputDialog("Digite seu email"));
			UsuarioBO bo = new UsuarioBO();
			bo.verificaUsuario(u);
			System.out.println(bo.verificaUsuario(u));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
