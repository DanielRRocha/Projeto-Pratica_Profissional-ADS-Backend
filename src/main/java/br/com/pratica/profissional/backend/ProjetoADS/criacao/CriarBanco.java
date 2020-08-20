package br.com.pratica.profissional.backend.ProjetoADS.criacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.Constants;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;

public class CriarBanco {

	/**
	 * Cria o banco de dados com o nome que está em Constant
	 * 
	 * @throws SQLException
	 */
	
	public static void criaBancoDeDados() throws SQLException {

		Connection conexao = FabricaConexao.getConnection();
		
		String sql = "CREATE DATABASE IF NOT EXISTS ";
		FabricaConexao.comandoSql(conexao, sql, Constants.getNome_banco_dados());
		conexao.close();
	}

}
