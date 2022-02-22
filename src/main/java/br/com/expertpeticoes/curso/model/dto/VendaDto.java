package br.com.expertpeticoes.curso.model.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.expertpeticoes.curso.model.Venda;

public class VendaDto {

	private String email;
	private LocalDate data;
	private BigInteger valor;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public BigInteger getValor() {
		return valor;
	}
	
	public void setValor(BigInteger valor) {
		this.valor = valor;
	}
	
	public static List<VendaDto> toVendasDto(List<Venda> vendas) {
	
		List<VendaDto> vendasDt = new ArrayList<>();
		
		for(Venda venda : vendas) {
			VendaDto vendaDt = VendaDto.toVenda(venda);
			vendasDt.add(vendaDt);
		}
		
		return vendasDt;
	}
	
	private static VendaDto toVenda(Venda venda) {
		VendaDto vendaDt = new VendaDto();
		vendaDt.setData(venda.getData());
		vendaDt.setValor(venda.getValor());
		vendaDt.setEmail(venda.getEmail().getEmail());
		return vendaDt;
	}
}