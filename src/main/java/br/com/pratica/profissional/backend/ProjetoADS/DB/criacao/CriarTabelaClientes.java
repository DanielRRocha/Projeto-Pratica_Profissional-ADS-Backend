package br.com.pratica.profissional.backend.ProjetoADS.DB.criacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.PropertyHelper;

public class CriarTabelaClientes extends FabricaConexao {

	/**
	 * Cria a tabela Clientes
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	
	public static void criaTabelaClientes() throws SQLException {
		
		Connection conexao = getConnection(PropertyHelper.getStringProperty("env.banco.nome"));
		
		String sql = "CREATE TABLE IF NOT EXISTS clientes ("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL,"
				+ "email VARCHAR(250) NOT NULL"
				+ ")";
		
		comandoSql(conexao, sql);
		
		System.out.println("Tabela criada com sucesso");
		
		conexao.close();
		
	}
}
