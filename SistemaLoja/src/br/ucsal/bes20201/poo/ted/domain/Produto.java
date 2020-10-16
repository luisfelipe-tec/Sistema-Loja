package br.ucsal.bes20201.poo.ted.domain;

public class Produto {

	private static Integer COD = 001;

	private Integer codigo;
	private String nome;
	private String descricao;
	private Double preco;
	private String dataVencimento;
	private Integer quantidade;

	public Produto(String nome, String descricao, Double valor, String dataVencimento, Integer quantidade) {

		this.codigo = COD;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = valor;
		this.dataVencimento = dataVencimento;
		this.quantidade = quantidade;
		COD++;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String toString() {
		return "Produto: \n| Código: " + codigo + " | Nome: " + nome;
	}

	public String toStringDescritivo() {
		return " \n Produto: \n  Código: " + codigo + " | Nome: " + nome + " | Qtd: " + quantidade + " | Preco: " + preco + " reais"
				+ " | Vencimento: " + dataVencimento + " \n Descrição: " + descricao + "\n";
	}

}
