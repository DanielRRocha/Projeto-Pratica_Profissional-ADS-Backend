package br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;

public class InserirUsuarios {

	private static Logger logger = LogManager.getLogger(InserirUsuarios.class);
			
			
	/**
	 * Inserir usuarios na tabela usuarios
	 * 
	 * @author danielrocha
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public static void inserirUsuarios() {

		try {
		Usuario admin = new Usuario(1L, "Administrador");
		Usuario prestador = new Usuario(2L, "Prestador");
		Usuario cliente = new Usuario(3L, "Cliente");

		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		
		dao.incluirAtomico(admin);
		dao.incluirAtomico(prestador);
		dao.incluirAtomico(cliente).fechar();
		
		} catch (RollbackException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
