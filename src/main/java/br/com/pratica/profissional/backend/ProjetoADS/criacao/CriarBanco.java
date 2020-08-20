package br.com.pratica.profissional.backend.ProjetoADS.criacao;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.Utils.PropertyHelper;

public class CriarBanco extends FabricaConexao {

	/**
	 * Cria o banco de dados com o nome que está em Constant
	 * 
	 * @throws SQLException
	 * @throws InvalidAlgorithmParameterException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	
	public static void criaBancoDeDados() throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		Connection conexao = getConnection();
		
		String sql = "CREATE DATABASE IF NOT EXISTS ";
		comandoSql(conexao, sql, PropertyHelper.getStringProperty("env.banco.nome"));
		conexao.close();
	}

}
