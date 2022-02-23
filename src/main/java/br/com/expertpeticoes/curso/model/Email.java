package br.com.expertpeticoes.curso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private Boolean cursoGratuito;
	private Boolean cursoPago;
	private Boolean propaganda;
	@OneToOne(mappedBy = "email")
	@PrimaryKeyJoinColumn
	private Venda venda;
	
	public Email() {
		
	}
	
	public Email(String email, Boolean cursoGratuito, Boolean cursoPago, Boolean propaganda) {
		super();
		this.email = email;
		this.cursoGratuito = cursoGratuito;
		this.cursoPago = cursoPago;
		this.propaganda = propaganda;
	}
	public Long getId() {
		return id;
	}
	public Email setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Email setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public Boolean getCursoGratuito() {
		return cursoGratuito;
	}
	
	public Email setCursoGratuito(Boolean cursoGratuito) {
		this.cursoGratuito = cursoGratuito;
		return this;
	}
	
	public Boolean getCursoPago() {
		return cursoPago;
	}
	
	public Email setCursoPago(Boolean cursoPago) {
		this.cursoPago = cursoPago;
		return this;
	}
	
	public Boolean getPropaganda() {
		return propaganda;
	}
	
	public Email setPropaganda(Boolean propaganda) {
		this.propaganda = propaganda;
		return this;
	}
	public Venda getVenda() {
		return venda;
	}
	public Email setVenda(Venda venda) {
		this.venda = venda;
		return this;
	}
	
	@Override
	public String toString() {
		return this.email;
	}
	
}
