package br.ucsal.bes20201.poo.ted.business;

import br.ucsal.bes20201.poo.ted.domain.Funcionario;
import br.ucsal.bes20201.poo.ted.exception.InvalidoException;
import br.ucsal.bes20201.poo.ted.exception.NaoEncontradoException;
import br.ucsal.bes20201.poo.ted.persistence.FuncionarioDAO;

public class FuncionarioBO {

	public static void cadastrarFuncionarioBO(Funcionario funcionario) throws Exception {

		if (verificarFuncionario(funcionario)) {
			FuncionarioDAO.cadastrarFuncionarioDAO(funcionario);
		} else {
			throw new InvalidoException("CPF invalido");
		}

	}

	private static boolean verificarFuncionarioAtivo(Funcionario funcionario) {

		if (FuncionarioDAO.listaFuncionario().isEmpty()) {
			return false;
		} else {
			for (int i = 0; i < FuncionarioDAO.listaFuncionario().size(); i++) {
				if (funcionario.equals(FuncionarioDAO.listaFuncionario().get(i))) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean verificarFuncionario(Funcionario funcionario) throws Exception {

		if (!verificarFuncionarioAtivo(funcionario)) {
			if (verificarCPF(funcionario.getCpf()) && verificarAnoNascimento(funcionario.getAnoNascimento())) {
				return true;
			}
		}

		return false;
	}

	private static boolean verificarAnoNascimento(Integer anoNascimento) throws Exception {
		int anoAtual = 2020;
		if (anoNascimento >= (anoAtual - 72) && anoNascimento < (anoAtual - 18)) {
			return true;
		}

		throw new InvalidoException("Ano de nascimento invalido");
	}

	public static boolean verificarCPF(String cpf) throws Exception {

		if (cpf.replace(".", "").replace("-", "").length() == 11) {
			for (int i = 0; i < FuncionarioDAO.listaFuncionario().size(); i++) {
				if (cpf.equals(FuncionarioDAO.listaFuncionario().get(i).getCpf())) {
					throw new InvalidoException("CPF invalido");
				}
			}
			return true;
		}

		throw new InvalidoException("CPF invalido");
	}

	public static boolean verificarFuncionarioCadastradoBO(String nome) throws NaoEncontradoException {

		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			throw new NaoEncontradoException("Caixa não preenchida!!");
		}
		if (FuncionarioDAO.listaFuncionario().isEmpty()) {
			throw new NaoEncontradoException("Não possui funcionários cadastrados!!");
		} else {
			for (int i = 0; i < FuncionarioDAO.listaFuncionario().size(); i++) {
				if (nome.equals(FuncionarioDAO.listaFuncionario().get(i).getNome())) {
					return true;
				}
			}
		}

		throw new NaoEncontradoException("Nome não encontrado no registro!!");
	}

	public static String listar() {

		String mensagem = "";

		for (int i = 0; i < FuncionarioDAO.listaFuncionario().size(); i++) {
			mensagem += FuncionarioDAO.listaFuncionario().get(i).toString();
		}

		return mensagem;
	}

	public static boolean verificarSenhaLoginVaziaBO(String senha) {

		if (senha.isBlank() || senha.isEmpty()) {
			return true;
		}

		return false;
	}

	public static boolean verificarSenhaLoginBO(String senha, String nome) {

		if (GerenteBO.verificarEhGerenteBO(senha, nome) || VendedorBO.verificarEhVendedorBO(senha, nome)) {
			return true;
		}

		return false;
	}

}
