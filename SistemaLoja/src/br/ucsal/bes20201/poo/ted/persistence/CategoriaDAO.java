package br.ucsal.bes20201.poo.ted.persistence;

import java.util.Map;
import java.util.TreeMap;
import br.ucsal.bes20201.poo.ted.domain.Categoria;

public class CategoriaDAO {

	private static Map<Integer, Categoria> categorias = new TreeMap<Integer, Categoria>();

	public static Map<Integer, Categoria> listar() {
		return new TreeMap<Integer, Categoria>(categorias);
	}

	public static void cadastrarCategoriaDAO(String descricao) {

		Categoria categoriaNova;

		categoriaNova = new Categoria(descricao);
		categorias.put(categoriaNova.getCodigo(), categoriaNova);

	}

	public static void removerCategoria(String categoriaRemovida) {

		categorias.remove(Integer.parseInt(categoriaRemovida));

	}

	public static void alterarCategoria(Integer codigo, String descricao) {

		categorias.get(codigo).setDescricao(descricao);

	}

	public static Map<Integer, Categoria> listaCategoriasDAO() {
		return new TreeMap<Integer, Categoria>(categorias);
	}

}
