package br.com.pratica.profissional.backend.ProjetoADS;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.pratica.profissional.backend.ProjetoADS.DB.consulta.ConsultaUsuarios;
import br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao.InserirUsuarios;


public class TesteBancoDeDados {
	
	public static void main(String[] args) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		
		InserirUsuarios.inserirUsuarios();
		
		ConsultaUsuarios.showUsers();
		
	}
}
