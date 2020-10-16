package br.ucsal.bes20201.poo.ted.domain;

import java.util.Map;
import java.util.TreeMap;

public class Vendedor extends Funcionario {

	private String senha;
	private Map<String, Venda> vendas;

	public Vendedor(String cpf, String nome, Double salario, Integer anoNascimento, Integer anoContratado,
			String senha) {

		super(cpf, nome, salario, anoNascimento, anoContratado);
		this.senha = senha;

	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Map<String, Venda> getVendas() {
		return vendas;
	}

	public void setVendas(TreeMap<String, Venda> vendas) {
		this.vendas = vendas;
	}

}
