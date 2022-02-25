package br.com.expertpeticoes.curso.model;

import java.math.BigDecimal;
import java.util.List;

import br.com.expertpeticoes.curso.model.dto.VendaDto;

public class RelatorioVenda {

	private List<VendaDto> payments;
	private Integer totalPages;
	private Integer page;
	
	public RelatorioVenda(List<VendaDto> vendas, Integer page, Integer totalPages) {
		this.payments = vendas;
		this.totalPages = totalPages;
		this.page = page;
	}
	

	public List<VendaDto> getPayments() {
		return payments;
	}

	public void setPayments(List<VendaDto> payments) {
		this.payments = payments;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}


}
