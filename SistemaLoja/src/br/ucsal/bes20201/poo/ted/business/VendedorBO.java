package br.ucsal.bes20201.poo.ted.business;

import java.util.List;

import br.ucsal.bes20201.poo.ted.domain.Produto;
import br.ucsal.bes20201.poo.ted.domain.Venda;
import br.ucsal.bes20201.poo.ted.domain.Vendedor;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;
import br.ucsal.bes20201.poo.ted.persistence.FuncionarioDAO;
import br.ucsal.bes20201.poo.ted.persistence.VendedorDAO;

public class VendedorBO {

	public static boolean verificarEhVendedorBO(String senha, String nome) {
		for (int i = 0; i < FuncionarioDAO.listaFuncionario().size(); i++) {
			if (FuncionarioDAO.listaFuncionario().get(i) instanceof Vendedor) {
				if (senha != null && senha.equals(((Vendedor) FuncionarioDAO.listaFuncionario().get(i)).getSenha())
						&& nome.equals(FuncionarioDAO.listaFuncionario().get(i).getNome())) {
					return true;
				}
			}
		}

		return false;
	}

	public static void adicionarProdutoVenda(Integer codigoProduto, Integer quantidade) throws Exception {

		Produto produto = ProdutoBO.buscarProduto(codigoProduto);
		if (quantidade > produto.getQuantidade()) {
			throw new InvalidoException("quantidade informada maior que quantidade disponivel");
		} else {
			VendedorDAO.adicionarProdutoVenda(codigoProduto, quantidade);
		}
	}

	public static void finalizarCompra() {
		VendedorDAO.limparCarrinho();
	}

	public static void retirarProdutoVendaBO(Integer posicao) {
		VendedorDAO.retirarProdutoVenda(posicao);
	}

	public static Venda retornaVenda() {
		return VendedorDAO.venda;
	}

	public static List<Produto> retornaCompras() {
		return VendedorDAO.compras;
	}

	public static List<Integer> retornaQuantidade() {
		return VendedorDAO.quantidades;
	}

}
