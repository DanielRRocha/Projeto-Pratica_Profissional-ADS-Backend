package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.TipoUsuarioDAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.TipoUsuario;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;

public class ConsultaTipoUsuarios {

	private static Logger logger = LogManager.getLogger(ConsultaTipoUsuarios.class);
	
	/**
	 * Consulta ID e tipos de usuarios
	 * 
	 * @author danielrocha
	 */
	public static void showUsers() {

		try {
			TipoUsuarioDAO dao = new TipoUsuarioDAO();

			List<TipoUsuario> usuarios = dao.obterTodos();

			logger.info("Id  | Tipo");
			for (TipoUsuario usuario : usuarios) {
				logger.info(" " + usuario.getId() + "  | " + usuario.getTipo());
			}

			dao.fechar();
		} catch (RuntimeException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
