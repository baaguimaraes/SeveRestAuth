package br.com.serverest.usuarios;

import org.apache.commons.lang3.RandomStringUtils;

public class DadosUsuarios {
	
	public String emailRandom() {
		String caracteresPermitidos = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
		String email = "";
		String temp = RandomStringUtils.random(10, caracteresPermitidos);
		email = temp + "@hotmail.com";
		return email;	
	}
	
	public String requestBodyUsuario(String email) {
		return "{\r\n"
				+ "  \"nome\": \"Fulano da Silva\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"password\": \"teste\",\r\n"
				+ "  \"administrador\": \"true\"\r\n"
				+ "}";
	}

}
