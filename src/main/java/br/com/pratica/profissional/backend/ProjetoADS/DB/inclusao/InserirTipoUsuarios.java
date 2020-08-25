package br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.TipoUsuario;

public class InserirTipoUsuarios {

	private static Logger logger = LogManager.getLogger(InserirTipoUsuarios.class);
			
			
	/**
	 * Inserir tipo de usuarios na tabela tipoUsuarios
	 * 
	 * @author danielrocha
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public static void inserirTipoUsuarios() {

		try {
		TipoUsuario admin = new TipoUsuario(1L, "Administrador");
		TipoUsuario prestador = new TipoUsuario(2L, "Prestador");
		TipoUsuario cliente = new TipoUsuario(3L, "Cliente");

		DAO<TipoUsuario> dao = new DAO<TipoUsuario>(TipoUsuario.class);
		
		dao.incluirAtomico(admin);
		dao.incluirAtomico(prestador);
		dao.incluirAtomico(cliente).fechar();
		
		} catch (RollbackException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
