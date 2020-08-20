package br.com.pratica.profissional.backend.ProjetoADS.inclusao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.PropertyHelper;

public class NovoCliente extends FabricaConexao {

	/**
	 * Insere no banco de dados cliente recebido do FrontEnd
	 * 
	 * @param nome
	 * @param email
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	
	public static void inserirCliente(String nome, String email) throws SQLException {
		
		Connection conexao = getConnection(PropertyHelper.getStringProperty("env.banco.nome"));
		
		String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
		
		comandoSql(conexao, sql, nome, email);
		
		System.out.println("Cliente incluido com sucesso!");
		
		conexao.close();
	}
}
