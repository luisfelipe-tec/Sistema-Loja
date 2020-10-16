package br.ucsal.bes20201.poo.ted.persistence;

import java.util.List;

import br.ucsal.bes20201.poo.ted.business.CategoriaBO;
import br.ucsal.bes20201.poo.ted.domain.Produto;

public class ProdutoDAO {

	public static void salvarProdutoDAO(Integer codigo, Produto produto) {

		List<Produto> produtos = retornarListaProdutosDAO(codigo);
		boolean nomeEhIgual = false;
		for (int i = 0; i < produtos.size(); i++) {
			nomeEhIgual = produto.equals(produtos.get(i));
		}
		int index = produtos.indexOf(produto);
		if (nomeEhIgual) {
			produtos.get(index).setQuantidade(produtos.get(index).getQuantidade() + produto.getQuantidade());
			;
		} else {
			produtos.add(produto);
		}

	}

	public static void excluirDAO(Integer codigo, Produto produto) {

		CategoriaBO.listaCategoriasBO().get(codigo).getProdutos().remove(produto);

	}

	public static List<Produto> retornarListaProdutosDAO(Integer codigoCategoria) {
		List<Produto> produtos = CategoriaBO.listaCategoriasBO().get(codigoCategoria).getProdutos();

		return produtos;
	}

	public static void alterar(Integer codigo, Integer codigoProduto, String nomeNovo, String descricaoNova,
			Double precoNovo, String dataVencimentoNova, Integer quantidadeNova) {

		List<Produto> produtos = retornarListaProdutosDAO(codigo);

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo().equals(codigoProduto)) {
				produtos.get(i).setNome(nomeNovo);
				produtos.get(i).setDescricao(descricaoNova);
				produtos.get(i).setPreco(precoNovo);
				produtos.get(i).setDataVencimento(dataVencimentoNova);
				produtos.get(i).setQuantidade(quantidadeNova);
			}
		}
	}

}
