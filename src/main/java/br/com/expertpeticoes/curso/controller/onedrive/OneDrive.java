package br.com.expertpeticoes.curso.controller.onedrive;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import br.com.expertpeticoes.curso.model.Valor;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OneDrive {

	private String refresh_token;
	private String access_token;
	private String redirectUrl;
	private String client_secret;

	public OneDrive(String refresh, String clientSecret, String redirectUrl) {
		this.refresh_token = refresh;
		this.redirectUrl = redirectUrl;
		this.client_secret = clientSecret;
		this.updateToken();
	}

	public void updateToken() {

		OkHttpClient client = new OkHttpClient();
		RequestBody requestBody = new FormBody.Builder().add("client_id", "a12d075f-754e-40f4-8958-021142ffb2e7")
				.add("redirect_uri", this.redirectUrl).add("grant_type", "refresh_token")
				.add("client_secret", client_secret).add("refresh_token", this.refresh_token).build();

		Request request = new Request.Builder().url("https://login.microsoftonline.com/consumers/oauth2/v2.0/token")
				.post(requestBody).build();

		Response response = null;
		String json = null;

		try {
			response = client.newCall(request).execute();
			json = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject jsonObject = null;

		try {
			jsonObject = (JSONObject) new JSONParser().parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("update");

		this.access_token = jsonObject.get("access_token").toString();
		this.refresh_token = jsonObject.get("refresh_token").toString();
	}

	public String getLink(String path) {
		OkHttpClient client = new OkHttpClient();

		JSONObject json = new JSONObject();
		json.put("type", "view");
		json.put("scope", "anonymous");

		int decisao = 0;

		do {
			
			RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json.toString());
			Request request = new Request.Builder()
					.url("https://graph.microsoft.com/v1.0/me/drive/items/root:" + path + ":/createLink")
					.post(requestBody).addHeader("Authorization", this.access_token).build();

			Response response = null;
			String js = null;
			try {
				response = client.newCall(request).execute();
				js = response.body().string();
			} catch (IOException e) {
				e.printStackTrace();
			}

			JSONObject resposta = null;

			try {
				resposta = (JSONObject) new JSONParser().parse(js);

				if (resposta.get("error") == null) {
					resposta = (JSONObject) new JSONParser().parse(resposta.get("link").toString());
					return resposta.get("webUrl").toString();
				} else {
					decisao++;
					this.updateToken();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} while (decisao == 1);
		
		return "error";
	}

	public String getToken() {
		return this.refresh_token;
	}

	public void setToken(String token) {
		this.access_token = token;
	}
}