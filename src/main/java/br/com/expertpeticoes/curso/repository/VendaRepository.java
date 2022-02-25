package br.com.expertpeticoes.curso.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import br.com.expertpeticoes.curso.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	@Query(value = "SELECT v FROM Venda v WHERE v.email.email = :email")
	public Optional<Venda> findByEmail(@Param(value = "email") String email);
	
	@Query(value = "SELECT v FROM Venda v WHERE v.email.email = :email")
	public Page<Venda> findVendasByEmail(Pageable pageable, 
			@Param(value = "email") String email);
	
	@Query(value = "SELECT v FROM Venda v WHERE v.valor = :valor")
	public Page<Venda> findVendasByPreco(Pageable pageable, 
			@Param(value = "valor") BigInteger valor);
	
	@Query(value = "SELECT v FROM Venda v WHERE v.data = :data")
	public Page<Venda> findVendasByData(Pageable pageable, 
			@Param(value = "data") LocalDate date);
	
	@Query(value = "SELECT v FROM Venda v WHERE v.data >= :inicial and v.data <= :final")
	public Page<Venda> findVendasByPeriodo(Pageable pageable,
			@Param(value = "inicial") LocalDate dataInicial,
			@Param(value = "final") LocalDate dataFinal);
	
	@Query(value = "SELECT SUM(v.valor) FROM Venda v")
	public BigDecimal getValorTotal();
}
