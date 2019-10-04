package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.bo.TurmaBO;
import br.com.cative.dao.TurmaDAO;
import br.com.cative.dao.UsuarioDAO;

public class TesteCriaTurmaAddAluno {

	public static void main(String[] args) {
		try {
			TurmaDAO turmaDAO = new TurmaDAO();
			String nomeTurma = JOptionPane.showInputDialog("Digite o nome da turma");
			Turma turma = turmaDAO.addTurma(nomeTurma);
			
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno");
			String emailAluno = JOptionPane.showInputDialog("Digite o email do aluno");
			int tipoAluno = 1; 
			
			Usuario usuario = usuarioDAO.adicionaUsuarioComDadosBasicos(nomeAluno, emailAluno, tipoAluno);
			
			turmaDAO.adicionaAlunoEmTurma(usuario.getIdUsuario(), turma.getIdTurma());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
