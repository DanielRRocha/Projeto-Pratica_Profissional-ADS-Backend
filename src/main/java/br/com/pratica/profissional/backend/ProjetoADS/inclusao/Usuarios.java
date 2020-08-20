package br.com.pratica.profissional.backend.ProjetoADS.inclusao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.PropertyHelper;

public class Usuarios extends FabricaConexao {

	/**
	 * Insere no banco de dados os tipos de usuarios
	 * 
	 * @throws SQLException
	 * 
	 * @author danielrocha
	 */
	
	public static void inserirUsuarios() {
		
		Connection conexao = getConnection(PropertyHelper.getStringProperty("env.banco.nome"));
		
		try {
		
		String sql = "INSERT INTO usuarios (codigo, tipo) VALUES (?,?)";
		
		comandoSql(conexao, sql, 1, "Administrador");
		comandoSql(conexao, sql, 2, "Profissional");
		comandoSql(conexao, sql, 3, "Cliente");
		
		System.out.println("Usuarios incluidos com sucesso!");
		
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("Usuarios já existente na tabela!");
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
