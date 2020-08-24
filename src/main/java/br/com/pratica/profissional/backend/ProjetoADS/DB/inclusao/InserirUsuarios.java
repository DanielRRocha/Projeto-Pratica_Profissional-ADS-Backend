package br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.TipoUsuario;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.Constants;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.Crypto;

public class InserirUsuarios {

	private static Logger logger = LogManager.getLogger(InserirTipoUsuarios.class);
	
	/**
	 * Inclui usuario na tabela com os parametros passados
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param username
	 * @param cpf
	 * @param email
	 * @param senha
	 * @param tipo_usuario
	 * @throws SQLIntegrityConstraintViolationException
	 * 
	 * @author danielrocha
	 */
	public static void inserirClientes(String nome, String sobrenome, String username, Long cpf, String email, String senha, Long tipo_usuario) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("marido_de_aluguel"); // nome do persistence-unit no xml
		EntityManager em = emf.createEntityManager();
		
		logger.info("Procurando tipo de usuario");
		TipoUsuario usuario = em.find(TipoUsuario.class, tipo_usuario);
		
		logger.info("Criptografando senha");
		String senha_cripto = Crypto.encrypt(senha, Constants.crypto_key);
		logger.info("Senha criptografada");
		Usuario cliente = new Usuario(nome, sobrenome, username, cpf, email, senha_cripto, usuario);
		
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		
			dao.incluirAtomico(cliente).fechar();
	}
}
