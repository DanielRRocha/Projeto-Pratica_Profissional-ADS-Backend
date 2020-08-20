package br.com.pratica.profissional.backend.ProjetoADS;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.FabricaConexao;


public class TesteConexao {

	public static void main(String[] args) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		Connection conexao = FabricaConexao.getConnection();
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
	}
}
