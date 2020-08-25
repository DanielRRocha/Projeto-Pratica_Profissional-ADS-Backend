package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.TipoUsuarioDAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.TipoUsuario;

@RestController
@RequestMapping(path = "/users")
public class ConsultaTipoUsuarios {

	private static Logger logger = LogManager.getLogger(ConsultaTipoUsuarios.class);
	
	/**
	 * Consulta ID e tipos de usuarios
	 * 
	 * @author danielrocha
	 * @return 
	 */
//	public static void showUsers() {
//
//		try {
//			TipoUsuarioDAO dao = new TipoUsuarioDAO();
//
//			List<TipoUsuario> usuarios = dao.obterTodos();
//
//			logger.info("Id  | Tipo");
//			for (TipoUsuario usuario : usuarios) {
//				logger.info(" " + usuario.getId() + "  | " + usuario.getTipo());
//			}
//
//			dao.fechar();
//		} catch (RuntimeException e) {
//			logger.error(e);
//			e.printStackTrace();
//		}
//	}
	
	@GetMapping(path = "/show")
	public static List<TipoUsuario> showUsers() {
		
		try {
			TipoUsuarioDAO dao = new TipoUsuarioDAO();
			logger.info("Obtendo Lista com tipos de usuarios");
			List<TipoUsuario> usuarios = dao.obterTodos();
			logger.info("Retornando lista com tipos de usuarios");
			return usuarios;
		} catch (RuntimeException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}
}
