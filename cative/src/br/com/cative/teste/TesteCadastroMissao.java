package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Missao;
import br.com.cative.bo.MissaoBO;

public class TesteCadastroMissao {

	public static void main(String[] args) throws Exception {
		try {
			Missao m = new Missao();
			m.setIdMissao(1);
			m.setObjetivo(JOptionPane.showInputDialog("Digite o objetivo da missao"));
			m.setDescricao(JOptionPane.showInputDialog("Digite os detalhes da missão"));
			m.setPontos(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pontos")));
			MissaoBO bo = new MissaoBO();
			System.out.println(bo.novaMissao(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
