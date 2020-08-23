package br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao;

import javax.persistence.RollbackException;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DAO.model.Usuario;

public class InserirUsuarios {

	/**
	 * Inserir usuarios na tabela usuarios
	 * 
	 * @author danielrocha
	 */
	public static void inserirUsuarios(){

		try {
		Usuario admin = new Usuario(1L, "Administrador");
		Usuario prestador = new Usuario(2L, "Prestador");
		Usuario cliente = new Usuario(3L, "Cliente");

		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		
		dao.incluirAtomico(admin);
		dao.incluirAtomico(prestador);
		dao.incluirAtomico(cliente).fechar();
		
		} catch (RollbackException e) {
			System.out.println(e);
			System.out.println("Possivel causa - Tabela e usuarios já existem!");
		}
	}
}
