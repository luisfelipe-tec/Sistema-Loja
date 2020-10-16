package br.ucsal.bes20201.poo.ted.gui;

import javax.swing.JOptionPane;

public class GerenteGUI {

	public static Integer menuGerente() {

		String[] opcao = { "Menu de Estoque", "Menu de Venda", "Cadastrar Funcionário", "Listar Funcionários", "Desconectar" };
		Integer escolha = JOptionPane.showOptionDialog(null, "Selecione a opção desejada", ":<<Menu gerente>>:",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
		if (escolha >= 0) {
			escolha += 1;
		} else {
			escolha = -1;
		}

		return escolha;
	}

	public static Integer menuEstoque() {

		Integer escolha = -1;
		String[] opcao = { "Categoria", "Produto", "Voltar" };
		String[] opcao0 = { "Cadastrar Categoria", "Remover Categoria", "Alterar Categoria", "Consultar Categoria",
				"Listar", "Voltar" };
		String[] opcao1 = { "Cadastrar Produto", "Remover Produto", "Consultar Produto", "Alterar Produto", "Voltar" };

		int confirmaOpcao = JOptionPane.showOptionDialog(null, ":<<Menu Estoque>>:?", null, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
		if (confirmaOpcao == 0) {
			escolha = JOptionPane.showOptionDialog(null, "Opções Categoria", null, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcao0, opcao0[0]);
			if (escolha >= 0) {
				escolha += 1;
			} else {
				escolha = -1;
			}
			if (escolha.equals(5) || escolha.equals(6)) {
				escolha += 4;
			}
		} else if (confirmaOpcao == 1) {
			escolha = JOptionPane.showOptionDialog(null, "Opções Produto", null, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcao1, opcao1[0]);
			if (escolha >= 0) {
				escolha += 5;
			} else {
				escolha = -1;
			}
			if (escolha.equals(9))
				escolha += 1;
		} else if (confirmaOpcao == 2) {
			escolha = 10;
		} else {
			escolha = -1;
		}

		return escolha;
	}

}
