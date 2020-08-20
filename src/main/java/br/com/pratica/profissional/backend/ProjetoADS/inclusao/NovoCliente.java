package br.com.pratica.profissional.backend.ProjetoADS.inclusao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.Constants;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;

public class NovoCliente {

	/**
	 * Insere no banco de dados cliente recebido do FrontEnd
	 * 
	 * @param nome
	 * @param email
	 * @throws SQLException
	 */
	
	public static void inserirCliente(String nome, String email) throws SQLException {
		
		Connection conexao = FabricaConexao.getConnection(Constants.getNome_banco_dados());
		
		String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
		
		FabricaConexao.comandoSql(conexao, sql, nome, email);
		
		System.out.println("Cliente incluido com sucesso!");
		
		conexao.close();
	}
}
