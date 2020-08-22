package br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao;

import javax.persistence.RollbackException;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.DB.model.Usuario;

public class InserirUsuarios extends FabricaConexao{

	/**
	 * Inserir usuarios na tabela usuarios
	 * 
	 * @author danielrocha
	 */
	public static void inserirUsuarios(){

		try {
			
		getConnection_Hibernate();

		Usuario admin = new Usuario(1L, "Administrador");
		Usuario prestador = new Usuario(2L, "Prestador");
		Usuario cliente = new Usuario(3L, "Cliente");

		getEm().getTransaction().begin();
		getEm().persist(admin);
		getEm().persist(prestador);
		getEm().persist(cliente);
		getEm().getTransaction().commit();

		getEm().close();
		getEmf().close();
		} catch (RollbackException e) {
			System.out.println(e);
			System.out.println("Possivel causa - Tabela e usuarios já existem!");
		}
	}
}
