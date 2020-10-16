package br.ucsal.bes20201.poo.ted.gui;

import javax.swing.JOptionPane;

import br.ucsal.bes20201.poo.ted.business.VendedorBO;
import br.ucsal.bes20201.poo.ted.domain.enums.PagamentoEnum;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;

public class VendaGUI {

	public static void venderGUI() throws Exception {

		String mensagem = notaParcialItemGUI();
		PagamentoEnum tipoPagamento1 = PagamentoEnum.CARTAO;
		PagamentoEnum tipoPagamento2 = PagamentoEnum.CARTAO2;
		PagamentoEnum tipoPagamento3 = PagamentoEnum.DINHEIRO;
		Object[] opcaoPagamento = { tipoPagamento1, tipoPagamento2, tipoPagamento3 };
		int pagamento = JOptionPane.showOptionDialog(null, "Como vai pagar", null, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcaoPagamento, opcaoPagamento[0]);
		if (pagamento == 0) {
			VendedorBO.retornaVenda().setTipoPagamento(tipoPagamento1);
		} else if (pagamento == 1) {
			VendedorBO.retornaVenda().setTipoPagamento(tipoPagamento2);
		} else if (pagamento == 2) {
			VendedorBO.retornaVenda().setTipoPagamento(tipoPagamento3);
		} else {
			throw new InvalidoException("Tipo de pagamento invalido!");
		}
		Object[] opcao = { "Sim", "Não" };
		int confirmaNota = JOptionPane.showOptionDialog(null, "Deseja imprimir a nota fiscal?", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
		if (confirmaNota == 0) {
			JOptionPane.showMessageDialog(null, mensagem + VendedorBO.retornaVenda().toString());
			VendedorBO.finalizarCompra();
		} else if (confirmaNota != 0) {
			VendedorBO.finalizarCompra();
			JOptionPane.showMessageDialog(null, "Venda concluída.");
		}

	}

	public static void adicionarItemGUI() throws Exception {

		Integer codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
		Integer quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade comprada: "));

		VendedorBO.adicionarProdutoVenda(codigoProduto, quantidade);

	}

	public static void retirarItemGUI() throws NaoEncontradoException {

		Object[] opcoes = VendedorBO.retornaCompras().toArray();
		int j = 0;
		Object[] opcao = new Object[4];
		int posicao = 0;

		for (int i = 0; i < opcoes.length; i++) {
			if (j <= opcoes.length - 3) {
				opcao[0] = opcoes[i];
				opcao[1] = opcoes[i + 1];
				opcao[2] = opcoes[i + 2];
				opcao[3] = "proximo";
				j++;
				posicao = JOptionPane.showOptionDialog(null, "Escolha o produto", null, JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opcao, opcoes[0]);

				if (posicao < 3) {
					posicao = i + posicao;
					break;
				} else {
					posicao = -1;
				}

			}
		}

		if (posicao >= 0) {
			VendedorBO.retirarProdutoVendaBO(posicao);
		} else {
			throw new NaoEncontradoException("Posição inválida");
		}

	}

	public static void consultarItemGUI() {
		String mensagem = "";

		for (int i = 0; i < VendedorBO.retornaCompras().size(); i++) {
			mensagem += VendedorBO.retornaCompras().get(i).toString() + " Qnt :" + VendedorBO.retornaQuantidade().get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public static String notaParcialItemGUI() {
		String mensagem = "";
		Double parcial = 0.0;
		Double total = 0.0;

		for (int i = 0; i < VendedorBO.retornaCompras().size(); i++) {
			parcial = VendedorBO.retornaQuantidade().get(i) * VendedorBO.retornaCompras().get(i).getPreco();
			mensagem += VendedorBO.retornaCompras().get(i).toString() + " Qnt*Preco :" + VendedorBO.retornaQuantidade().get(i) + " * "
					+ VendedorBO.retornaCompras().get(i).getPreco() + "= " + parcial + "\n  ";
			total += parcial;
		}

		VendedorBO.retornaVenda().setValorCompra(total);

		return mensagem;
	}

}
