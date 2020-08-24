package br.com.pratica.profissional.backend.ProjetoADS;

import br.com.pratica.profissional.backend.ProjetoADS.DB.consulta.ConsultaTipoUsuarios;
import br.com.pratica.profissional.backend.ProjetoADS.DB.consulta.ConsultaUsuarios;
import br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao.InserirTipoUsuarios;
import br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao.InserirUsuarios;


public class TesteBancoDeDados {
	
	public static void main(String[] args) {
		
//		InserirTipoUsuarios.inserirTipoUsuarios();
		
//		ConsultaTipoUsuarios.showUsers();
		
//		InserirUsuarios.inserirClientes("Marli", "Rocha", "marlirocha", 23648974825L, "marlirosario@globo.com" , "1234", 3l);
		
//		ConsultaUsuarios.buscarUsuarioViaId(3L);
		
		ConsultaUsuarios.buscarUsuarioViaCpf(23648974825L);
	}
}
