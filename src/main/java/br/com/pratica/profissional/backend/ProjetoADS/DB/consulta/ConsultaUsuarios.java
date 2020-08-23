package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.util.List;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.UsuarioDAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;

public class ConsultaUsuarios {

	/**
	 * Consulta ID e tipos de usuarios
	 * 
	 * @author danielrocha
	 */
	public static void showUsers() {

		try {
			UsuarioDAO dao = new UsuarioDAO();

			List<Usuario> usuarios = dao.obterTodos();

			System.out.println("\n\nId  | Tipo");
			for (Usuario usuario : usuarios) {
				System.out.println(" " + usuario.getId() + "  | " + usuario.getTipo());
			}

			dao.fechar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
