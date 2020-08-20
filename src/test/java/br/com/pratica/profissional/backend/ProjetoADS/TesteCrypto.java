package br.com.pratica.profissional.backend.ProjetoADS;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.pratica.profissional.backend.ProjetoADS.Utils.Crypto;

public class TesteCrypto {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		String value = "12345678";
		String key = "123";
//		String value = "QALx0lgHnVLkAGSpf/Q/Mw==";
		
		String crypto = Crypto.encrypt(value, key);
		
//		String crypto = Crypto.decrypt(value, key);
//		
		System.out.println(value);
		System.out.println(key);
		System.out.println(crypto);
	}
	
}
