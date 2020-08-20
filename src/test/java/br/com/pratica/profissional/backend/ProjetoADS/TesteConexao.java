package br.com.pratica.profissional.backend.ProjetoADS;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;


public class TesteConexao {

	public static void main(String[] args) throws SQLException {

		Connection conexao = FabricaConexao.getConnection();
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
	}
}
