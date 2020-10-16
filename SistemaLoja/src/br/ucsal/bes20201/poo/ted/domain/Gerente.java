package br.ucsal.bes20201.poo.ted.domain;

public class Gerente extends Funcionario {

	private String senha;

	public Gerente(String cpf, String nome, Double salario, Integer anoNascimento, Integer anoContratado,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gerente other = (Gerente) obj;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
