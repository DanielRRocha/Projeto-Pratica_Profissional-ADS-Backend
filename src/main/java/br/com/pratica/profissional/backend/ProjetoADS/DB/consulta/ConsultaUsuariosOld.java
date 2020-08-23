package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.DB.model.Usuario;

public class ConsultaUsuariosOld extends FabricaConexao {

	
	/**
	 * Consulta ID e tipos de usuarios
	 * 
	 * @author danielrocha
	 */
	public static void showUsers() {
		
		try {
			
			getConnection_Hibernate();
			
			Usuario admin = getEm().find(Usuario.class, 1L);
			Usuario prestador = getEm().find(Usuario.class, 2L);
			Usuario cliente = getEm().find(Usuario.class, 3L);
			
			System.out.println("\n\nId  | Tipo");
			System.out.println(" " + admin.getId() + "  | " + admin.getTipo());
			System.out.println(" " + prestador.getId() + "  | " + prestador.getTipo());
			System.out.println(" " + cliente.getId() + "  | " + cliente.getTipo()+ "\n\n");
			
			closeConnection();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
