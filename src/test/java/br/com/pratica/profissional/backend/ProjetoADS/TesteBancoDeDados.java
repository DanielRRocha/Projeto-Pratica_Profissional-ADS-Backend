package br.com.pratica.profissional.backend.ProjetoADS;

import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.criacao.CriarBanco;
import br.com.pratica.profissional.backend.ProjetoADS.criacao.CriarTabelaClientes;


public class TesteBancoDeDados {
	
	public static void main(String[] args) throws SQLException {
		
//		CriarBanco.criaBancoDeDados();
		
		CriarTabelaClientes.criaTabelaClientes();
	}
}
