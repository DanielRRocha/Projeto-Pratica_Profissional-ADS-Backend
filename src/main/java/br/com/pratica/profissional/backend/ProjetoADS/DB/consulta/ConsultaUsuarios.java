package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.util.List;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.DB.infra.UsuarioDAO;
import br.com.pratica.profissional.backend.ProjetoADS.DB.model.Usuario;

public class ConsultaUsuarios extends FabricaConexao {

	
	/**
	 * Consulta ID e tipos de usuarios
	 * 
	 * @author danielrocha
	 */
	public static void showUsers() {
		
		try {
			
//			ProdutoDAO dao = new ProdutoDAO();
//			List<Produto> produtos = dao.obterTodos();
//			
//			for(Produto produto: produtos) {
//				System.out.println("Id: " + produto.getId() + ",  Nome: " + produto.getNome());
//			}
			
			UsuarioDAO dao = new UsuarioDAO();
			
			List<Usuario> usuarios = dao.obterTodos();
			
			System.out.println("\n\nId  | Tipo");
			for(Usuario usuario: usuarios) {
				System.out.println(" " + usuario.getId() + "  | " + usuario.getTipo());
			}
			
			dao.fechar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
