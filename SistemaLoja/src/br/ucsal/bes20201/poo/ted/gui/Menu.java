package br.ucsal.bes20201.poo.ted.gui;

import javax.swing.JOptionPane;

import br.ucsal.bes20201.poo.ted.business.CategoriaBO;
import br.ucsal.bes20201.poo.ted.business.FuncionarioBO;
import br.ucsal.bes20201.poo.ted.business.ProdutoBO;
import br.ucsal.bes20201.poo.ted.domain.Funcionario;
import br.ucsal.bes20201.poo.ted.domain.Gerente;
import br.ucsal.bes20201.poo.ted.domain.Produto;
import br.ucsal.bes20201.poo.ted.domain.Vendedor;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;

public class Menu {

	public static Boolean LOGOFF;

	public static void main(String[] args) {
		inicializarVariaveis();
		try {
			inicio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void inicializarVariaveis() {
		try {
			Funcionario adm = new Gerente("123.456.789-01", "Adm", 1800.43, 1979, 2000, "34521");
			Funcionario mariana = new Vendedor("123.456.250-01", "Mariana", 666.97, 1990, 2020, "3421");
			Produto maca = new Produto("Maça", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto pessego = new Produto("Pessego", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto goiaba = new Produto("Goiaba", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto jaca = new Produto("Jaca", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto banana = new Produto("Banana", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto melancia = new Produto("Melancia", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto fileMignon = new Produto("file mignon", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto alcatra = new Produto("alcatra", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto frango = new Produto("Frango", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			Produto leite = new Produto("Leite", "Uma fruta saborosa", 2.0, "17/06/2020", 50);
			FuncionarioBO.cadastrarFuncionarioBO(adm);
			FuncionarioBO.cadastrarFuncionarioBO(mariana);
			CategoriaBO.cadastrarCategoriaBO("Frutas");
			CategoriaBO.cadastrarCategoriaBO("Carnes");
			CategoriaBO.cadastrarCategoriaBO("Laticinios");
			ProdutoBO.cadastrarProduto(1, maca);
			ProdutoBO.cadastrarProduto(1, banana);
			ProdutoBO.cadastrarProduto(1, melancia);
			ProdutoBO.cadastrarProduto(2, fileMignon);
			ProdutoBO.cadastrarProduto(2, alcatra);
			ProdutoBO.cadastrarProduto(2, frango);
			ProdutoBO.cadastrarProduto(3, leite);
			ProdutoBO.cadastrarProduto(1, pessego);
			ProdutoBO.cadastrarProduto(1, goiaba);
			ProdutoBO.cadastrarProduto(1, jaca);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void inicio() throws Exception {

		String nome;
		String senha;
		int tentativa = 0;
		Integer escolha = 0;
		boolean existe;

		do {
			tentativa = 0;

			LOGOFF = false;

			nome = JOptionPane.showInputDialog("Informe seu nome");

			existe = FuncionarioBO.verificarFuncionarioCadastradoBO(nome);

			if (existe) {
				senha = entrarSenha(nome, tentativa);
				if (FuncionarioBO.verificarSenhaLoginBO(senha, nome)) {
					escolha = FuncionarioGUI.escolherGUI(senha, nome);
				} else {
					throw new InvalidoException("Tentativas expiradas");
				}
			} else {
				throw new NaoEncontradoException("Nome não encontrado no registro");
			}

			while (!escolha.equals(-1) && !LOGOFF) {
				escolha = FuncionarioGUI.escolherGUI(senha, nome);
			}
			if (escolha.equals(-1)) {
				tentativa++;
			}
		} while (tentativa == 0 || LOGOFF);

	}

	public static String entrarSenha(String nome, int tentativa) {

		String senha = "";

		senha = JOptionPane.showInputDialog("Entre com sua senha");
		boolean senhaEhVazia = FuncionarioBO.verificarSenhaLoginVaziaBO(senha);
		tentativa++;
		if ((senhaEhVazia || !FuncionarioBO.verificarSenhaLoginBO(senha, nome)) && tentativa < 3) {
			senha = entrarSenha(nome, tentativa);
		}

		return senha;
	}

	public static void menuGerente(Integer escolha, String senha, String nome) throws Exception {

		switch (escolha) {
		case 1:
			try {
				menuEstoque(GerenteGUI.menuEstoque(), senha, nome);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 2:
			try {
				int escolhaMenuVendedor=0;
				while(escolhaMenuVendedor != -1 && escolhaMenuVendedor != 6) {
				escolhaMenuVendedor = VendedorGUI.menuVendedor();
				menuVenda(escolhaMenuVendedor); 
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 3:
			try {
				FuncionarioGUI.cadastrarFuncionarioGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 4:
			try {
				FuncionarioGUI.listarFuncionarioGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 5:

			JOptionPane.showMessageDialog(null, "Tchau por enquanto...");
			LOGOFF = true;
			break;
		default:

			break;
		}

	}

	public static void menuVenda(Integer escolha) throws Exception, NaoEncontradoException, InvalidoException {

		switch (escolha) {
		case 1:
			try {
				VendaGUI.venderGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 2:
			try {
				VendaGUI.adicionarItemGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 3:
			try {
				VendaGUI.retirarItemGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 4:
			try {
				VendaGUI.consultarItemGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 5:
			try {
				JOptionPane.showMessageDialog(null, VendaGUI.notaParcialItemGUI());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 6:

			JOptionPane.showMessageDialog(null, "Tchau por enquanto...");
			LOGOFF = true;
			break;
		default:

			break;
		}

	}

	public static void menuEstoque(Integer escolha, String senha, String nome) throws Exception {

		switch (escolha) {
		case 1:
			try {
				CategoriaGUI.cadastrarCategoriaGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 2:

			try {
				CategoriaGUI.removerCategoriaGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 3:

			try {
				CategoriaGUI.alterarCategoriaGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 4:

			try {
				CategoriaGUI.consultarCategoriaGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 5:

			try {
				ProdutoGUI.cadastrarProdutoGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 6:
			try {
				ProdutoGUI.removerProdutoGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 7:

			try {
				ProdutoGUI.consultarProdutoGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 8:
			try {
				ProdutoGUI.alterarProdutoGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 9:
			try {
				CategoriaGUI.listarTodasGUI();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 10:
			try {
				FuncionarioGUI.escolherGUI(senha, nome);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 11:

			JOptionPane.showMessageDialog(null, "Até a próxima...");

			break;
		default:

			break;

		}
	}

}
