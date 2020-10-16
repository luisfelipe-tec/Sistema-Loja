package br.ucsal.bes20201.poo.ted.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.ucsal.bes20201.poo.ted.domain.Categoria;
import br.ucsal.bes20201.poo.ted.domain.Produto;
import br.ucsal.bes20201.poo.ted.exception.CaracteresExcedidosException;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;
import br.ucsal.bes20201.poo.ted.persistence.CategoriaDAO;
import br.ucsal.bes20201.poo.ted.persistence.ProdutoDAO;

public class ProdutoBO {

	private static boolean validarChave(Integer codigo) throws NaoEncontradoException {

		boolean chaveEhValida = CategoriaBO.verificarChaveCategoriaBO(codigo);
		if (!CategoriaBO.listaCategoriasBO().isEmpty() && chaveEhValida) {
			return true;
		}

		return false;
	}

	private static boolean validarProduto(Produto produto) throws Exception {

		validaNome(produto.getNome());
		validaDescricao(produto.getDescricao());
		validaPreco(produto.getPreco());

		return true;
	}

	private static void validaPreco(double preco) throws Exception {
		if (preco <= 0) {
			throw new InvalidoException(" Preco invalido! ");
		}
	}

	private static void validaDescricao(String descricao) throws Exception {
		if (descricao == null) {
			throw new NaoEncontradoException(" Descricao invalida! ");
		} else if (descricao.length() > 64) {
			throw new CaracteresExcedidosException("");
		}

	}

	private static void validaNome(String nome) throws InvalidoException {
		if (nome == null || nome.length() > 160) {
			throw new InvalidoException(" Nome invalido! ");
		}
	}

	public static void cadastrarProduto(Integer codigo, Produto produto) throws Exception {

		if (validarChave(codigo) && validarProduto(produto)) {
			ProdutoDAO.salvarProdutoDAO(codigo, produto);
		}

	}

	public static void removerProdutoBO(Integer codigoCategoria, String nome) throws NaoEncontradoException {

		List<Produto> produtos = ProdutoDAO.retornarListaProdutosDAO(codigoCategoria);
		boolean encontrado = false;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(nome)) {
				ProdutoDAO.excluirDAO(codigoCategoria, produtos.get(i));
				encontrado = true;
			}
		}

		if (encontrado == false) {
			throw new NaoEncontradoException("Produto nao encontrado!");
		}

	}

	public static void alterarProdutoBO(Integer codigoCategoria, Integer codigoProduto, String nomeNovo,
			String descricaoNova, Double precoNovo, String dataVencimentoNova, Integer quantidadeNova) {

		ProdutoDAO.alterar(codigoCategoria, codigoProduto, nomeNovo, descricaoNova, precoNovo, dataVencimentoNova,
				quantidadeNova);

	}

	public static Produto buscarProduto(Integer codigoProduto) throws NaoEncontradoException {
		Map<Integer, Categoria> categorias = CategoriaBO.listaCategoriasBO();
		Object[] aux = categorias.keySet().toArray();
		for (int i = 0; i < CategoriaDAO.listaCategoriasDAO().size(); i++) {
			for (int j = 0; j < CategoriaDAO.listaCategoriasDAO().get(aux[i]).getProdutos().size(); j++) {
				if (codigoProduto
						.equals(CategoriaDAO.listaCategoriasDAO().get(aux[i]).getProdutos().get(j).getCodigo())) {
					return CategoriaDAO.listaCategoriasDAO().get(aux[i]).getProdutos().get(j);
				}
			}
		}

		throw new NaoEncontradoException("Produto nao econtrado");
	}

	public static List<Produto> listarTodos(Integer codigo, String nome) {

		List<Produto> produtos = new ArrayList<Produto>();
		for (int i = 0; i < ProdutoDAO.retornarListaProdutosDAO(codigo).size(); i++) {
			if (ProdutoDAO.retornarListaProdutosDAO(codigo).get(i).getNome().equals(nome)) {
				produtos.add(ProdutoDAO.retornarListaProdutosDAO(codigo).get(i));
			}
		}
		return produtos;

	}

	public static String mensagemAtributosProdutoBO(List<Produto> produtos, String nome) {

		String mensagem = null;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(nome)) {
				mensagem = produtos.get(i).getCodigo() + " " + produtos.get(i).getNome() + " "
						+ produtos.get(i).getDescricao() + "  Preço-" + produtos.get(i).getPreco() + " ";
			}
		}

		return mensagem;
	}

}
