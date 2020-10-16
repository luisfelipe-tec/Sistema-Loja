package br.ucsal.bes20201.poo.ted.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes20201.poo.ted.business.ProdutoBO;
import br.ucsal.bes20201.poo.ted.domain.Produto;
import br.ucsal.bes20201.poo.ted.domain.Venda;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;

public class VendedorDAO {

	public static List<Produto> compras = new ArrayList<Produto>();
	public static List<Integer> quantidades = new ArrayList<Integer>();

	public static Venda venda = new Venda();

	public static void retirarProdutoVenda(int posicao) {
		compras.get(posicao).setQuantidade(compras.get(posicao).getQuantidade() + quantidades.get(posicao));
		compras.remove(posicao);
		quantidades.remove(posicao);
	}

	public static void adicionarProdutoVenda(Integer codigo, Integer quantidade) throws NaoEncontradoException {
		Produto produto = ProdutoBO.buscarProduto(codigo);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		compras.add(produto);
		quantidades.add(quantidade);
		venda.setProdutos(compras);
		venda.setQuantidades(quantidades);
	}

	public static void limparCarrinho() {
		compras.clear();
	}
}
