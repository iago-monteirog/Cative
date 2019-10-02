package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Turma;
import br.com.cative.bo.TurmaBO;
import br.com.cative.dao.TurmaDAO;

public class TesteCadastroTurma {
		public static void main(String[] args) throws Exception {
			try {
				Turma t = new Turma();
				t.setNomeTurma(JOptionPane.showInputDialog("Digite o nome da turma"));
				
				TurmaBO bo = new TurmaBO();
				bo.novaTurma(t);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
