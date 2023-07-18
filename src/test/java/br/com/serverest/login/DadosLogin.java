package br.com.serverest.login;

import static org.junit.Assert.assertEquals;


import br.com.serverest.usuarios.DadosUsuarios;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DadosLogin {

	
	private Response response;
	DadosUsuarios dadosUsuarios = new DadosUsuarios();
	String url = "https://serverest.dev";


	public String requestBodyLogin(String email) {
		return "{\r\n" + "  \"email\": \"" + email + "\",\r\n" + "  \"password\": \"teste\"\r\n" + "}";
	}

	public String retornaToken() {
		//  criar um usuário
		String emailRandom = dadosUsuarios.emailRandom();
		response = RestAssured.given().contentType(ContentType.JSON).body(dadosUsuarios.requestBodyUsuario(emailRandom))
				.post(url + "/usuarios");
		
		assertEquals(201, response.statusCode());
		assertEquals("Cadastro realizado com sucesso", response.jsonPath().getString("message"));

		// aqui o login
		response = RestAssured.given().contentType(ContentType.JSON).body(requestBodyLogin(emailRandom))
				.post(url + "/login");
		
		assertEquals(200, response.statusCode());
		assertEquals("Login realizado com sucesso", response.jsonPath().getString("message"));

		
		return response.jsonPath().getString("authorization");
	}
}
