package br.ucsal.bes20201.poo.ted.domain;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private static Integer COD = 001;

	private Integer codigo;
	private String nomeCategoria;
	private List<Produto> produtos;

	public Categoria(String nome) {

		this.codigo = COD;
		this.nomeCategoria = nome;
		this.produtos = new ArrayList<Produto>();
		COD++;

	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return nomeCategoria;
	}

	public void setDescricao(String nome) {
		this.nomeCategoria = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return " Categoria : " + nomeCategoria +  " | Código : " + codigo + "\n" ;
	}

}
