package br.com.pratica.profissional.backend.ProjetoADS.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaConexao {

	/**
	 * Inicia conexão com banco de dados
	 * 
	 * @author danielrocha
	 */
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root";
			final String senha = "12345678";

			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Inicia conexão com banco de dados com nome como parâmetro
	 * 
	 * @param name
	 * 
	 * @author danielrocha
	 */
	public static Connection getConnection(String name) {
		try {
			String url = "jdbc:mysql://localhost:3306/"+ name + "?verifyServerCertificate=false&useSSL=true";
			final String user = "root";
			final String password = "12345678";

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Envia comando SQL para o banco de dados
	 * 
	 * @param conexao
	 * @param sql
	 * @throws SQLException
	 */
	public static void comandoSql(Connection conexao, String sql) throws SQLException {

		Statement stmt = conexao.createStatement();

		String comando = sql;
		
		stmt.execute(comando);
		
		System.out.println("Comando sql '" + comando + "' realizado com sucesso");
	}

	/**
	 * Envia comando SQL para o banco de dados
	 * 
	 * @param conexao
	 * @param sql
	 * @param nome
	 * @throws SQLException
	 */
	public static void comandoSql(Connection conexao, String sql, String nome) throws SQLException {

		Statement stmt = conexao.createStatement();

		String comando = sql + nome;
		
		stmt.execute(comando);
		
		System.out.println("Comando sql '" + comando + "' realizado com sucesso");
	}
}