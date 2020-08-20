package br.com.pratica.profissional.backend.ProjetoADS.criacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.PropertyHelper;

public class CriaTabelaTipoUsuario extends FabricaConexao{

	/**
	 * Cria a tabela Usuarios
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	
	public static void criaTabelaUsuarios() throws SQLException {
		
		Connection conexao = getConnection(PropertyHelper.getStringProperty("env.banco.nome"));
		
		String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
				+ "codigo INT (1) NOT NULL PRIMARY KEY,"
				+ "tipo VARCHAR(20) NOT NULL,"
				+ "UNIQUE KEY (codigo),"
				+ "UNIQUE KEY (tipo)"
				+ ")";

		comandoSql(conexao, sql);
		
		System.out.println("Tabela criada com sucesso");
		
		conexao.close();
		
	}
}