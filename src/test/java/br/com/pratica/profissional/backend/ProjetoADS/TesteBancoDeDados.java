package br.com.pratica.profissional.backend.ProjetoADS;

import java.sql.SQLException;

import br.com.pratica.profissional.backend.ProjetoADS.DB.consulta.ConsultaUsuarios;
import br.com.pratica.profissional.backend.ProjetoADS.DB.criacao.CriaTabelaTipoUsuario;
import br.com.pratica.profissional.backend.ProjetoADS.DB.criacao.CriarBanco;
import br.com.pratica.profissional.backend.ProjetoADS.DB.criacao.CriarTabelaClientes;
import br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao.NovoCliente;
import br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao.Usuarios;


public class TesteBancoDeDados {
	
	public static void main(String[] args) throws SQLException {
		
//		CriarBanco.criaBancoDeDados();
		
//		CriarTabelaClientes.criaTabelaClientes();
		
//		NovoCliente.inserirCliente("Daniel 3", "daniel3@gmail.com");
		
//		CriaTabelaTipoUsuario.criaTabelaUsuarios();
		
//		Usuarios.inserirUsuarios();
		
		ConsultaUsuarios.consultaUsuarios();
	}
}
