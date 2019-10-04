package br.com.cative.teste;

import javax.swing.JOptionPane;

import br.com.cative.beans.Missao;
import br.com.cative.bo.MissaoBO;

public class TesteCadastroMissao {

	public static void main(String[] args) throws Exception {
		try {
			Missao missao = new Missao();
			missao.setIdMissao(1);
			missao.setObjetivo(JOptionPane.showInputDialog("Digite o objetivo da missao"));
			missao.setDescricao(JOptionPane.showInputDialog("Digite os detalhes da missão"));
			missao.setPontos(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pontos")));
			MissaoBO bo = new MissaoBO();
			bo.novaMissao(missao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
