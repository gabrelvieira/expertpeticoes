package br.com.expertpeticoes.curso.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private Boolean cursoGratuito;
	private Boolean cursoPago;
	private Boolean Propaganda;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getCursoGratuito() {
		return cursoGratuito;
	}
	
	public void setCursoGratuito(Boolean cursoGratuito) {
		this.cursoGratuito = cursoGratuito;
	}
	
	public Boolean getCursoPago() {
		return cursoPago;
	}
	
	public void setCursoPago(Boolean cursoPago) {
		this.cursoPago = cursoPago;
	}
	
	public Boolean getPropaganda() {
		return Propaganda;
	}
	
	public void setPropaganda(Boolean propaganda) {
		Propaganda = propaganda;
	}
	
	
}
