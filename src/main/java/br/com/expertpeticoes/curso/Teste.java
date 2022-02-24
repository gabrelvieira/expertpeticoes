package br.com.expertpeticoes.curso;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.model.form.EmailForm;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Teste {

	public static void main(String[] args) {
		OkHttpClient ok = new OkHttpClient();
		Request request = new Request.Builder().url("https://expertpeticoes.com/adm/api/vendas?value=null&type=ALL&page=1&direction=ASC").build();
		
		Response response = null;
		
		try {
			response =ok.newCall(request).execute();
			System.out.println(response.body().string());
		} catch(Exception e) {
			
		}
		System.out.println("acabou");
		
	}
}
