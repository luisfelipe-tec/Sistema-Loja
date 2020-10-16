package br.ucsal.bes20201.poo.ted.domain;

public class Funcionario {

	private String cpf;
	private String nome;
	private Double salario;
	private Integer anoNascimento;
	private Integer anoContratado;

	public Funcionario(String cpf, String nome, Double salario, Integer anoNascimento, Integer anoContratado) {

		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
		this.anoNascimento = anoNascimento;
		this.anoContratado = anoContratado;

	}

	public Integer getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Integer getAnoContratado() {
		return anoContratado;
	}

	public void setAnoContratado(Integer anoContratado) {
		this.anoContratado = anoContratado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n Funcionário : " + nome + " | CPF : " + cpf + " | Salário : " + salario + " reais"
				+ " | Ano de Nascimento : " + anoNascimento + " | Ano de contratação : " + anoContratado;
	}

}
