package br.ucsal.bes20201.poo.ted.gui;

import java.util.List;

import javax.swing.JOptionPane;

import br.ucsal.bes20201.poo.ted.business.ProdutoBO;
import br.ucsal.bes20201.poo.ted.domain.Produto;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;

public class ProdutoGUI {

	public static void cadastrarProdutoGUI() throws Exception {

		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da categoria: "));
		String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
		String descricaoProduto = JOptionPane.showInputDialog("Insira uma descrição à esse produto: ");
		Double preco = Double.parseDouble(
				JOptionPane.showInputDialog("Digite o valor cobrado pela venda deste produto: ").replace(",", "."));
		String vencimento = JOptionPane.showInputDialog("Por ultimo a data de validade(dd/mm/aaa): ");
		Integer qnt = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque:"));
		Produto produto = new Produto(nome, descricaoProduto, preco, vencimento, qnt);

		ProdutoBO.cadastrarProduto(codigo, produto);
	}

	public static void removerProdutoGUI() throws NaoEncontradoException {

		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da categoria: "));
		String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");

		ProdutoBO.removerProdutoBO(codigo, nome);
		JOptionPane.showMessageDialog(null, "Produto removido!!");

	}

	public static void alterarProdutoGUI() {

		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da categoria: "));
		Integer codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
		String nomeNovo = JOptionPane.showInputDialog("Digite novo nome: ");
		String descricaoNova = JOptionPane.showInputDialog("Digite a nova descrição do produto: ");
		Double precoNovo = Double.parseDouble(JOptionPane.showInputDialog("Digite novo valor: ").replace(",", "."));
		String dataVencimento = JOptionPane.showInputDialog("Digite a nova data de validade: ");
		Integer quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
		ProdutoBO.alterarProdutoBO(codigo, codigoProduto, nomeNovo, descricaoNova, precoNovo, dataVencimento,
				quantidade);

	}

	public static void consultarProdutoGUI() throws NaoEncontradoException {

		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da categoria: "));
		String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");

		List<Produto> produtos = ProdutoBO.listarTodos(codigo, nome);
		String mensagem = ProdutoBO.mensagemAtributosProdutoBO(produtos, nome);
		JOptionPane.showMessageDialog(null, mensagem);

	}

}
