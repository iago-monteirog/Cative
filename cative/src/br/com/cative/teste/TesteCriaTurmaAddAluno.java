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
			Turma t = new Turma();
			TurmaDAO dao = new TurmaDAO();
			TurmaBO bo = new TurmaBO();
			t.setNomeTurma(JOptionPane.showInputDialog("Digite o nome da turma"));
			t.setIdTurma(dao.getTurmaAlu(t.getIdTurma()));
			bo.novaTurma(t);
			Usuario u = new Usuario();
			UsuarioDAO udao = new UsuarioDAO();
			u.setNome(JOptionPane.showInputDialog("Digite o nome do aluno"));
			u.setIdUsuario((udao.getAluTurma(u.getNome())));
			dao.addAluno(u.getIdUsuario(), t.getIdTurma(), u.getNome(), t.getNomeTurma());
			System.out.println("Aluno adicionado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
