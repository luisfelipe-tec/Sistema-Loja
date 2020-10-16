package br.ucsal.bes20201.poo.ted.gui;

import javax.swing.JOptionPane;

public class VendedorGUI {

	public static Integer menuVendedor() {

		Integer escolha = -1;
		String[] opcao = { "Confirmar Venda", "Adicionar Item", "Retirar Item", "Consultar Venda",
				"Mostrar Nota Parcial", "Desconectar" };

		escolha = JOptionPane.showOptionDialog(null, "Selecione a opção desejada", ":<<Menu Venda>>:", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

		if (escolha >= 0) {
			escolha += 1;
		} else {
			escolha = -1;
		}

		return escolha;
	}

}
