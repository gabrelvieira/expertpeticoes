package br.com.expertpeticoes.curso.controller.pagamento;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.stereotype.Service;

public class DadosPayment {

	private String AcessToken = "TEST-2758722863515157-021322-deffced8237d3c9baed43db5551af479-1068321036";
	private BigDecimal valor;
	private Boolean promocao;
	private BigDecimal valorPromocional;
	
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

	public String getAcessToken() {
		return AcessToken;
	}
	
	public void setAcessToken(String acessToken) {
		AcessToken = acessToken;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
