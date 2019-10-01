package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Turma;
import br.com.cative.beans.Usuario;
import br.com.cative.dao.TurmaDAO;

public class TesteAdicionarAlunoEmTurma {

	public static void main(String[] args) {
		try {
			Turma t = new Turma();
			t.setIdTurma(1);
			Usuario u = new Usuario();
			u.setIdUsuario(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno")));
			TurmaDAO dao = new TurmaDAO();
			dao.addAluno(u.getIdUsuario(), t.getIdTurma(), u.getNome());
			System.out.println("Aluno adicionado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
