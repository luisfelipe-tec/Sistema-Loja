package br.ucsal.bes20201.poo.ted.business;

import br.ucsal.bes20201.poo.ted.domain.Gerente;
import br.ucsal.bes20201.poo.ted.persistence.FuncionarioDAO;

public class GerenteBO {

	public static boolean verificarEhGerenteBO(String senha, String nome) {

		for (int i = 0; i < FuncionarioDAO.listaFuncionario().size(); i++) {
			if (FuncionarioDAO.listaFuncionario().get(i) instanceof Gerente) {
				if (senha != null && senha.equals(((Gerente) FuncionarioDAO.listaFuncionario().get(i)).getSenha())
						&& nome.equals(FuncionarioDAO.listaFuncionario().get(i).getNome())) {
					return true;
				}
			}
		}

		return false;
	}

}
