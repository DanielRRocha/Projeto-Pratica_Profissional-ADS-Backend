package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.UsuarioDAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;

public class ConsultaUsuarios {

	private static Logger logger = LogManager.getLogger(ConsultaUsuarios.class);
	

	/**
	 * Imprime no console os dados do cliente
	 * 
	 * @param usuario
	 * 
	 * @author danielrocha
	 */
	private static void imprimirDadosUsuario(Usuario usuario) {
		logger.info("ID: " + usuario.getId());
		logger.info("Nome: " + usuario.getNome());
		logger.info("Sobrenome: " + usuario.getSobrenome());
		logger.info("E-mail: " + usuario.getEmail());
		logger.info("Username: " + usuario.getUsername());
		logger.info("CPF: " + usuario.getCpf());
		logger.info("Tipo de Usuario: " + usuario.getUsuario());
		
	}
	
	/**
	 * Busca dados do usuario via ID passado como parametro
	 * 
	 * @param id
	 * 
	 * @author danielrocha
	 */
	public static void buscarUsuarioViaId(Long id) {
		
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		Usuario it = dao.buscarUsuarioPeloTipo(id);
		
		imprimirDadosUsuario(it);
	}
	
	/**
	 * Busca dados do usuario via CPF passado como parametro
	 * 
	 * @param id
	 * 
	 * @author danielrocha
	 */
	public static void buscarUsuarioViaCpf(long cpf) {

		DAO<Usuario> dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.obterTodos();
		boolean validacao = true;
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf() == cpf) {
				
				imprimirDadosUsuario(usuario);
				dao.fechar();
				validacao = false;
				break;
			}
		}
		if(validacao) {
			logger.error("Usuário não encontrado");
			dao.fechar();
		}
	}
}
