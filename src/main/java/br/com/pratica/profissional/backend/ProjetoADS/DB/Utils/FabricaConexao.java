package br.com.pratica.profissional.backend.ProjetoADS.DB.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pratica.profissional.backend.ProjetoADS.Helpers.Crypto;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.PropertyHelper;

public class FabricaConexao extends Crypto {

	private static Connection conexao;
	
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	
	/**
	 * Inicia conexão com banco de dados utilizando framework jpa hibernate
	 * 
	 * @author danielrocha
	 */
	public static void getConnection_Hibernate() {
		emf = Persistence.createEntityManagerFactory("marido_de_aluguel");
		em = emf.createEntityManager();
	}
	
	/**
	 * 
	 * @return
	 */
	public static EntityManager getEm() {
		return em;
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

}