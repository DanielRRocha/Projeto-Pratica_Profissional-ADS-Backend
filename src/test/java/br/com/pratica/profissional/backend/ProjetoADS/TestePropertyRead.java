package br.com.pratica.profissional.backend.ProjetoADS;

import java.io.IOException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.PropertyHelper;

public class TestePropertyRead {

	public static void main(String[] args) throws IOException {
		
		System.out.println(PropertyHelper.getStringProperty("env.banco.url"));
	}
}
