package br.ucsal.bes20201.poo.ted.persistence;

import java.util.ArrayList;
import java.util.List;
import br.ucsal.bes20201.poo.ted.domain.Funcionario;

public class FuncionarioDAO {

	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public static void cadastrarFuncionarioDAO(Funcionario funcionario) {

		funcionarios.add(funcionario);

	}

	public static List<Funcionario> listaFuncionario() {
		return new ArrayList<Funcionario>(funcionarios);
	}

}
