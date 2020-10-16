package br.ucsal.bes20201.poo.ted.gui;

import javax.swing.JOptionPane;

import br.ucsal.bes20201.poo.ted.business.CategoriaBO;
import br.ucsal.bes20201.poo.ted.domain.Categoria;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;

public class CategoriaGUI {

	public static void cadastrarCategoriaGUI() {

		String descricao = JOptionPane.showInputDialog(":<<Cadastrar>>: \nDigite o nome dessa Categoria: ");
		try {
			CategoriaBO.cadastrarCategoriaBO(descricao);
		} catch (InvalidoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void removerCategoriaGUI() throws Exception {

		String categoriaRemovida = JOptionPane.showInputDialog(":<<Remover>>: \nDigite o codigo da categoria: ");

		Categoria descricao = CategoriaBO.listaCategoriasBO().get(Integer.parseInt(categoriaRemovida));

		CategoriaBO.removerCategoria(categoriaRemovida);

		String[] opcao = { "Sair", "Voltar" };
		JOptionPane.showOptionDialog(null, "A categoria " + descricao.getDescricao() + " foi removida", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
		GerenteGUI.menuEstoque();

	}

	public static void alterarCategoriaGUI() throws Exception {
		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(":<<Alterar>>: \nDigite o codigo da categoria:"));
		String descricao = JOptionPane.showInputDialog(":<<Alterar>>: \nDigite o novo nome da categoria:");
		CategoriaBO.alterarCategoria(codigo, descricao);
	}

	public static void consultarCategoriaGUI() throws Exception {

		Integer codigo = Integer
				.parseInt(JOptionPane.showInputDialog(":<<Consultar>>: \nDigite o codigo da categoria:"));

		String descricao = CategoriaBO.retornaNomeCategoria(codigo);

		JOptionPane.showMessageDialog(null, "Código: " + codigo + "\nNome: " + descricao);

	}

	public static void listarTodasGUI() {

		Object[] keys = new Integer[CategoriaBO.listaCategoriasBO().size()];
		keys = CategoriaBO.listaCategoriasBO().keySet().toArray();
		String[] opcao = { "Voltar", "Próximo" };

		int i = 0;
		do {
			String mensagem = CategoriaBO.listaCategoriasBO().get(keys[i]).toString();
			for (int j = 0; j < CategoriaBO.listaCategoriasBO().get(keys[i]).getProdutos().size(); j++) {
				mensagem += CategoriaBO.listaCategoriasBO().get(keys[i]).getProdutos().get(j).toStringDescritivo();
			}

			int prox = JOptionPane.showOptionDialog(null, mensagem, null, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
			if (prox == 0) {
				if (i == 0) {

				} else {
					i--;
				}
			} else if (prox == 1) {
				i++;
			} else {
				i = CategoriaBO.listaCategoriasBO().size();
			}
		} while (i > 0 && i < CategoriaBO.listaCategoriasBO().size());

	}

}
