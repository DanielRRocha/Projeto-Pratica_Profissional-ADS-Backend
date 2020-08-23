package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.UsuarioDAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;

public class ConsultaUsuarios {

	private static Logger logger = LogManager.getLogger(ConsultaUsuarios.class);
	
	/**
	 * Consulta ID e tipos de usuarios
	 * 
	 * @author danielrocha
	 */
	public static void showUsers() {

		try {
			UsuarioDAO dao = new UsuarioDAO();

			List<Usuario> usuarios = dao.obterTodos();

			logger.info("Id  | Tipo");
			for (Usuario usuario : usuarios) {
				logger.info(" " + usuario.getId() + "  | " + usuario.getTipo());
			}

			dao.fechar();
		} catch (RuntimeException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
