package br.com.pratica.profissional.backend.ProjetoADS.criacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.PropertyHelper;

public class CriarTabelaClientes extends FabricaConexao {

	/**
	 * Cria a tabela Clientes
	 * 
	 * @throws SQLException
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
