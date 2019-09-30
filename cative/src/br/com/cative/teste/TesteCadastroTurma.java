package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Turma;
import br.com.cative.dao.TurmaDAO;

public class TesteCadastroTurma {
		public static void main(String[] args) throws Exception {
			try {
				Turma t = new Turma();
				t.setIdTurma(0);
				t.setNomeTurma(JOptionPane.showInputDialog("Digite o nome da turma"));
				TurmaDAO dao = new TurmaDAO();
				dao.addTurma(t);
				System.out.println("Turma " + t.getNomeTurma() + " Criada com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
