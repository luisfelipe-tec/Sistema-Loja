package br.ucsal.bes20201.poo.ted.gui;

import javax.swing.JOptionPane;

import br.ucsal.bes20201.poo.ted.business.FuncionarioBO;
import br.ucsal.bes20201.poo.ted.business.GerenteBO;
import br.ucsal.bes20201.poo.ted.business.VendedorBO;
import br.ucsal.bes20201.poo.ted.domain.Funcionario;
import br.ucsal.bes20201.poo.ted.domain.Gerente;
import br.ucsal.bes20201.poo.ted.domain.Vendedor;

public class FuncionarioGUI {

	public static Integer escolherGUI(String senha, String nome) throws Exception {

		Integer escolha = -1;

		boolean ehGerente;
		boolean ehVendedor;

		ehGerente = GerenteBO.verificarEhGerenteBO(senha, nome);
		ehVendedor = VendedorBO.verificarEhVendedorBO(senha, nome);

		if (ehGerente) {
			escolha = GerenteGUI.menuGerente();
			if (!escolha.equals(-1)) {
				Menu.menuGerente(escolha, senha, nome);
			}
		} else if (ehVendedor) {
			escolha = VendedorGUI.menuVendedor();
			if (!escolha.equals(-1)) {
				Menu.menuVenda(escolha);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Você não devia estar aqui");

		}

		return escolha;
	}

	public static void cadastrarFuncionarioGUI() throws Exception {

		String cpf = JOptionPane.showInputDialog("Digite o CPF:");
		if (FuncionarioBO.verificarCPF(cpf)) {
			String nome = JOptionPane.showInputDialog("Digite o nome:");
			if (nome != null) {
				Double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario").replace(",", "."));
				if (salario != null) {
					Integer anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento"));
					if (anoNascimento != null) {
						Integer anoContratado = 2020;
						if (anoContratado != null) {
							String[] opcao = { "Gerente", "Vendedor", "Outro" };

							String senha;
							int cargo = JOptionPane.showOptionDialog(null, "Registre o cargo do funcionario", null,
									JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
							Funcionario funcionario = new Funcionario(cpf, nome, salario, anoNascimento, anoContratado);

							if (cargo == 0) {
								senha = JOptionPane.showInputDialog("Digite uma senha:");
								funcionario = new Gerente(cpf, nome, salario, anoNascimento, anoContratado, senha);
							} else if (cargo == 1) {
								senha = JOptionPane.showInputDialog("Digite uma senha:");
								funcionario = new Vendedor(cpf, nome, salario, anoNascimento, anoContratado, senha);
							} else if (cargo == -1) {

							}

							FuncionarioBO.cadastrarFuncionarioBO(funcionario);

						}
					}
				}
			}
		}
	}


	public static void listarFuncionarioGUI() {

		String listaFuncionarios = FuncionarioBO.listar().replace("[", "").replace(",", "").replace("]", "\n");
		JOptionPane.showMessageDialog(null, listaFuncionarios + "\n");

	}

}
