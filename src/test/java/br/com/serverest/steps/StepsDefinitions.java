package br.com.serverest.steps;



import static org.junit.Assert.assertEquals;

import br.com.serverest.carrinhos.DadosCarrinhos;
import br.com.serverest.login.DadosLogin;
import br.com.serverest.usuarios.DadosUsuarios;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepsDefinitions {
	
	private Response response;
	DadosUsuarios dadosUsuarios = new DadosUsuarios();
	DadosLogin dadosLogin = new DadosLogin();
	DadosCarrinhos dadosCarrinhos = new DadosCarrinhos();
	String url = "https://serverest.dev";
	
	
	@Dado("que eu faca uma requisicao POST na rota \\/carrinhos com requestBody valido")
	public void que_eu_faca_uma_requisicao_post_na_rota_carrinhos_com_request_body_valido() {

		response = RestAssured.given()
				.header("Authorization", dadosLogin.retornaToken())
				.contentType(ContentType.JSON)
				.body(dadosCarrinhos.requestBodyCarrinhos())
				.post(url + "/carrinhos");
		
	}

	@Entao("valido status code {int}")
	public void valido_status_code(Integer int1) {
		assertEquals(Integer.valueOf(int1), Integer.valueOf(response.statusCode()));
	}

	@Dado("que eu faca uma requisicao POST na rota \\/carrinhos e envio SEM o requestBody")
	public void que_eu_faca_uma_requisicao_post_na_rota_carrinhos_e_envio_sem_o_request_body() {
	
		response = RestAssured.given()
				.header("Authorization", dadosLogin.retornaToken())
				.contentType(ContentType.JSON)
				.post(url + "/carrinhos");
	}

	@Entao("mensagem {string}")
	public void mensagem(String string) {
		assertEquals(string, response.jsonPath().getString("message"));

	}

	@Dado("que eu faca uma requisicao POST na rota \\/carrinhos e envio SEM o campo idProduto")
	public void que_eu_faca_uma_requisicao_post_na_rota_carrinhos_e_envio_sem_o_campo_id_produto() {
		response = RestAssured.given()
				.header("Authorization", dadosLogin.retornaToken())
				.contentType(ContentType.JSON)
				.body(dadosCarrinhos.requestBodyCarrinhosSemIDProduto())
				.post(url + "/carrinhos");
	
	}

    @Dado("que eu faca uma requisicao POST na rota \\/carrinhos e envio com campo idProduto com valor int")
    public void que_eu_faca_uma_requisicao_post_na_rota_carrinhos_e_envio_com_campo_id_produto_com_valor_int() {
    	response = RestAssured.given()
				.header("Authorization", dadosLogin.retornaToken())
				.contentType(ContentType.JSON)
				.body(dadosCarrinhos.requestBodyCarrinhosSemIDProduto())
				.post(url + "/carrinhos");
	
}
}