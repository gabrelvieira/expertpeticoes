package br.com.expertpeticoes.curso;

import java.util.ArrayList;
import java.util.List;

import br.com.expertpeticoes.curso.model.Email;

public class Teste {

	public static void main(String[] args) {
		Email email = new Email("gabrielvieira3101@gmail.com", false, false, true);
		
		List<Email> emails = new ArrayList<>();
		
		emails.add(email);
		emails.add(email);
		emails.add(email);
		emails.add(email);
		System.out.println(emails.toString().replace("[", "").replace("]", ""));
	}
}
