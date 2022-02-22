package br.com.expertpeticoes.curso.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.expertpeticoes.curso.model.RelatorioVenda;
import br.com.expertpeticoes.curso.model.TypeQuery;
import br.com.expertpeticoes.curso.model.Venda;
import br.com.expertpeticoes.curso.model.dto.VendaDto;
import br.com.expertpeticoes.curso.repository.VendaRepository;

@RestController
@RequestMapping("/adm/api")
public class VendaController {

	@Autowired
	private VendaRepository vendaRepository;
	
	@GetMapping("/vendas")
	public RelatorioVenda getVendas(
			@RequestParam(required = true, name = "type") TypeQuery type,
			@RequestParam(required = true, name = "value") String value,
			@RequestParam(required = true) int page,
			@RequestParam(defaultValue = "DESC") Direction direction) {
		
		Page<Venda> vendas = null;
		page--;
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(direction, "data"));
		
		if(type.name().equals(TypeQuery.DAY.name())) {
			
			if(value.contains("-")) {
				String[] datas = value.trim().replace(" ", "").split("-");
				LocalDate dataInicial = this.getData(datas[0].replace("/", "-"));
				LocalDate dataFinal = this.getData(datas[1].replace("/", "-"));
				vendas = this.vendaRepository.findVendasByPeriodo(pageable, dataInicial, dataFinal);
			}
			
			if(!value.contains("-")) {
				value = value.trim().replace(" ", "").replace("/", "-");
				LocalDate data = this.getData(value);
				vendas = this.vendaRepository.findVendasByData(pageable, data);
			}
			
		}
		
		if(type.name().equals(TypeQuery.EMAIL.name())) {
			 vendas = this.vendaRepository.findVendasByEmail(pageable, value);
		}
		
		if(type.name().equals(TypeQuery.VALOR.name())) {
			 vendas = this.vendaRepository.findVendasByPreco(pageable, new BigInteger(value));
		}
		
		if(type.name().equals(TypeQuery.ALL.name())) {
			 vendas = this.vendaRepository.findAll(pageable);
		}
		
		int paginaAtual = vendas.getNumber();
		
		RelatorioVenda relatorio = new RelatorioVenda(VendaDto.toVendasDto(vendas.toList()),
				++paginaAtual,
				vendas.getTotalPages());
		
		return relatorio;
	}
	
	private LocalDate getData(String date) {
		System.out.println(date);
		String[] values = date.split("-");
		
		LocalDate data = LocalDate.of(Integer.valueOf(values[2]), 
				Integer.valueOf(values[1]),
				Integer.valueOf(values[0]));
		return data;
		
	}
}
