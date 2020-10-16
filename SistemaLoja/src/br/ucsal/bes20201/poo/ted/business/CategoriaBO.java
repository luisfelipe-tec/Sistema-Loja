package br.ucsal.bes20201.poo.ted.business;

import java.util.Map;

import br.ucsal.bes20201.poo.ted.domain.Categoria;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;
import br.ucsal.bes20201.poo.ted.persistence.CategoriaDAO;

public class CategoriaBO {

	public static void cadastrarCategoriaBO(String descricao) throws InvalidoException {
		boolean nomeIndisponivel;

		nomeIndisponivel = verificarNomeCategoriaBO(descricao);
		if (!nomeIndisponivel) {
			CategoriaDAO.cadastrarCategoriaDAO(descricao);
		} else {
			throw new InvalidoException("Essa Descrição já existe ou é invalida");
		}
	}

	public static void removerCategoria(String categoria) throws NaoEncontradoException {

		boolean categoriaNaoExiste = verificarNomeCategoriaBO(categoria);
		if (!categoriaNaoExiste) {
			CategoriaDAO.removerCategoria(categoria);
		} else {
			throw new NaoEncontradoException("Categoria não encontrada!");
		}
	}

	public static void alterarCategoria(Integer codigo, String descricao) throws NaoEncontradoException {
		boolean nomeDisponivel = CategoriaBO.verificarNomeCategoriaBO(descricao);
		if (!nomeDisponivel) {
			CategoriaDAO.alterarCategoria(codigo, descricao);
		} else {
			throw new NaoEncontradoException("Categoria não encontrada!");
		}

	}

	private static boolean verificarNomeCategoriaBO(String descricao) {

		Map<Integer, Categoria> categorias = listaCategoriasBO();
		Object[] keys = new Integer[categorias.size()];
		keys = categorias.keySet().toArray();

		if (categorias.equals(null)) {
			return false;
		} else {
			for (int i = 0; i < keys.length; i++) {
				categorias.get(keys[i]).getDescricao();
				if (descricao.equals(categorias.get(keys[i]).getDescricao())) {
					return true;
				}
			}
		}

		return false;
	}

	public static String retornaNomeCategoria(Integer codigo) throws NaoEncontradoException {
		Map<Integer, Categoria> categorias = listaCategoriasBO();
		verificarChaveCategoriaBO(codigo);

		return categorias.get(codigo).getDescricao();
	}

	public static boolean verificarChaveCategoriaBO(Integer codigo) throws NaoEncontradoException {

		if (listaCategoriasBO() != null && listaCategoriasBO().containsKey(codigo)) {
			return true;
		}

		throw new NaoEncontradoException("Codigo não encontrado");
	}

	public static Map<Integer, Categoria> listaCategoriasBO() {
		return CategoriaDAO.listaCategoriasDAO();

	}
}
