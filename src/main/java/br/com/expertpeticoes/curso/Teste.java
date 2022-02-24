package br.com.expertpeticoes.curso;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.model.form.EmailForm;

public class Teste {

	public static void main(String[] args) {
		String json = "{\"email\":\"gabrielvieira3101@gmail.com\", "
				+ "\"id\":\"432\"}";
		EmailForm email = new Gson().fromJson(json, EmailForm.class);
		
		System.out.println(email.getEmail());
	}
}
