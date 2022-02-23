package br.com.expertpeticoes.curso.model.form;

import java.math.BigDecimal;

public class DadosPaymentForm {

	private BigDecimal valor;
	private Boolean promocao;
	private BigDecimal valorPromocional;
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Boolean getPromocao() {
		return promocao;
	}
	
	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}
	
	public BigDecimal getValorPromocional() {
		return valorPromocional;
	}

	public void setValorPromocional(BigDecimal valorPromocional) {
		this.valorPromocional = valorPromocional;
	}
	
}
