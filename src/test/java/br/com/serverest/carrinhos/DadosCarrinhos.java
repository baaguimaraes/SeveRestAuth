package br.com.serverest.carrinhos;

public class DadosCarrinhos {
	
	public String retornaRequestBodyValido() {
		return "{\r\n"
				+ "  \"produtos\": [\r\n"
				+ "    {\r\n"
				+ "      \"idProduto\": \"3d7JaLO8XzIfWCwS\",\r\n"
				+ "      \"quantidade\": 1\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"idProduto\": \"K6leHdftCeOJj8BJ\",\r\n"
				+ "      \"quantidade\": 3\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	public String requestBodySemResquest() {
		return "";
	}
	
	
	public String requestBodyCarrinhosSemIDProduto() {
		return "{\r\n"
				+ "  \"produtos\": [\r\n"
				+ "    {\r\n"
				+ "      \"quantidade\": 1\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"quantidade\": 3\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}

}
