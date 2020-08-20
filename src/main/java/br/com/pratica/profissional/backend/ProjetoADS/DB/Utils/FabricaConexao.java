package br.com.pratica.profissional.backend.ProjetoADS.DB.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.pratica.profissional.backend.ProjetoADS.Helpers.Crypto;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.PropertyHelper;

public class FabricaConexao extends Crypto {

	/**
	 * Inicia conexão com banco de dados
	 * 
	 * @author danielrocha
	 */
	
	public static Connection getConnection() {
		try {
			String url = PropertyHelper.getStringProperty("env.banco.url");
			final String usuario = PropertyHelper.getStringProperty("env.banco.usuario");
			final String senha = PropertyHelper.getStringProperty("env.banco.senha");

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
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	public static void comandoSql(Connection conexao, String sql) throws SQLException {

		Statement stmt = conexao.createStatement();

		String comando = sql;
		
		stmt.execute(comando);
		
		System.out.println("Comando sql \n'" + comando + "\n' realizado com sucesso");
	}

	/**
	 * Envia comando SQL para o banco de dados
	 * 
	 * @param conexao
	 * @param sql
	 * @param nome
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	public static void comandoSql_(Connection conexao, String sql, String nome) throws SQLException {

		Statement stmt = conexao.createStatement();

		String comando = sql + nome;
		
		stmt.execute(comando);
		
		System.out.println("Comando sql '" + comando + "' realizado com sucesso");
	}
	
	/**
	 * Envia comando SQL para o banco de dados com Segurança contra SQL Injection
	 * 
	 * @param conexao
	 * @param sql
	 * @param param1
	 * @param param2
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	public static void comandoSql(Connection conexao, String sql, int param1, String param2) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setLong(1, param1);
		stmt.setString(2, param2);

		stmt.execute();
		
		System.out.println("Comando sql realizado com sucesso");
	}
	
	/**
	 * Envia comando SQL para o banco de dados com Segurança contra SQL Injection
	 * 
	 * @param conexao
	 * @param sql
	 * @param param1
	 * @param param2
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	public static void comandoSql(Connection conexao, String sql, String param1, String param2) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, param1);
		stmt.setString(2, param1);

		stmt.execute();
		
		System.out.println("Comando sql realizado com sucesso");
	}
}