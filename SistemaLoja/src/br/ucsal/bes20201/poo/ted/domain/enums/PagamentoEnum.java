package br.ucsal.bes20201.poo.ted.domain.enums;

public enum PagamentoEnum {

	DINHEIRO(""), CARTAO("Crédito"), CARTAO2("Débito");

	private String tipoCartao;

	PagamentoEnum(String tipoCartao) {
		this.tipoCartao = tipoCartao;

	}

	public String getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

}