package br.com.cative.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.cative.beans.Missao;
import br.com.cative.dao.MissaoDAO;

public class TesteCadastroMissao {

	public static void main(String[] args) throws Exception {
		try {
			Missao m = new Missao();
			m.setIdMissao(1);
			m.setObjetivo(JOptionPane.showInputDialog("Digite o objetivo da missao"));
			m.setDescricao(JOptionPane.showInputDialog("Digite os detalhes da missão"));
			m.setPontos(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pontos")));
			MissaoDAO dao = new MissaoDAO();
			dao.AddMissaoBasic(m);
			System.out.println("Missão registrada com sucesso, Alguns detalhes" + m.getObjetivo() + m.getDescricao() + m.getPontos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
