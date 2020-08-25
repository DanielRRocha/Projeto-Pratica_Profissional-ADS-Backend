package br.com.pratica.profissional.backend.ProjetoADS.Helpers;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crypto {

	private final static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
	private static final IvParameterSpec ivspec = new IvParameterSpec(iv);
	
	private static ThreadLocal<Boolean> isInitiated = new ThreadLocal<Boolean>();
	private static ThreadLocal<Cipher> cipher = new ThreadLocal<Cipher>();
	
	private static Logger logger = LogManager.getLogger(Crypto.class);
	
	/**
	 * Inicializa "driver" da crypto
	 * 
	 * @author danielrocha
	 */
	private static void initialize() {
		
		if (isInitiated.get() == null || !isInitiated.get()) {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			
			try {
				cipher.set(Cipher.getInstance("AES/CBC/PKCS5Padding", "BC"));
			} catch (NoSuchAlgorithmException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				logger.error(e);
				e.printStackTrace();
			} 
			
			isInitiated.set(true);
		}
		
	}
	
	/**
	 * Criptografa uma String utilizando uma chave passada como parametro
	 * 
	 * @param value
	 * @param key
	 * 
	 * @return string criptografada
	 * 
	 * @author danielrocha
	 */
	public static String encrypt(String value, String key) {
		
		initialize();
		
		byte[] keyBytes = Base64.getDecoder().decode(key); 		
		SecretKeySpec keySpec = new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"); 		
		
		try {
			cipher.get().init(Cipher.ENCRYPT_MODE, keySpec, ivspec);
		} catch (InvalidKeyException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			logger.error(e);
			e.printStackTrace();
		} 
		
		String encode = null;
		try {
			encode = Base64.getEncoder().encodeToString(cipher.get().doFinal(value.getBytes(StandardCharsets.UTF_8)));
		} catch (IllegalBlockSizeException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (BadPaddingException e) {
			logger.error(e);
			e.printStackTrace();
		}
		
			return encode;
		
	}
	
	/**
	 * Descriptografa uma String utilizando uma chave passada como parametro
	 * 
	 * @param value
	 * @param key
	 * 
	 * @return string descriptografada
	 * 
	 * @author danielrocha
	 */
	public static String decrypt(String value, String key) {
		
		initialize();
		
		byte[] keyBytes = Base64.getDecoder().decode(key); 
		SecretKeySpec keySpec = new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"); 
		
		try {
			cipher.get().init(Cipher.DECRYPT_MODE, keySpec, ivspec);
		} catch (InvalidKeyException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			logger.error(e);
			e.printStackTrace();
		} 
	
		String decode = null;
		try {
			decode = new String(cipher.get().doFinal(Base64.getDecoder().decode(value)), StandardCharsets.UTF_8);
		} catch (IllegalBlockSizeException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (BadPaddingException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return decode; 
	
	}
	
}
