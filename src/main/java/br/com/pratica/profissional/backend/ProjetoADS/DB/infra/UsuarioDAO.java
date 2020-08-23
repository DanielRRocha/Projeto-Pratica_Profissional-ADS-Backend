package br.com.pratica.profissional.backend.ProjetoADS.DB.infra;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.DAO;
import br.com.pratica.profissional.backend.ProjetoADS.DB.model.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}
}
