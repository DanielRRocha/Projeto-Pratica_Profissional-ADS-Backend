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

public class Crypto {

	private final static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
	private static final IvParameterSpec ivspec = new IvParameterSpec(iv);
	
	private static ThreadLocal<Boolean> isInitiated = new ThreadLocal<Boolean>();
	private static ThreadLocal<Cipher> cipher = new ThreadLocal<Cipher>();
	
	/**
	 * Inicializa "driver" da crypto
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * 
	 * @author danielrocha
	 */
	private static void initialize() throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		
		if (isInitiated.get() == null || !isInitiated.get()) {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			
			cipher.set(Cipher.getInstance("AES/CBC/PKCS5Padding", "BC")); 
			
			isInitiated.set(true);
		}
		
	}
	
	/**
	 * Criptografa uma String utilizando uma chave passada como parametro
	 * 
	 * @param value
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * 
	 * @author danielrocha
	 */
	public static String encrypt(String value, String key) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException  {
		
		initialize();
		
		byte[] keyBytes = Base64.getDecoder().decode(key); 		
		SecretKeySpec keySpec = new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"); 		
		
		cipher.get().init(Cipher.ENCRYPT_MODE, keySpec, ivspec); 
		
		return Base64.getEncoder().encodeToString(cipher.get().doFinal(value.getBytes(StandardCharsets.UTF_8)));
		
	}
	
	/**
	 * Descriptografa uma String utilizando uma chave passada como parametro
	 * 
	 * @param value
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * 
	 * @author danielrocha
	 */
	public static String decrypt(String value, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		
		initialize();
		
		byte[] keyBytes = Base64.getDecoder().decode(key); 
		SecretKeySpec keySpec = new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"); 
		
		cipher.get().init(Cipher.DECRYPT_MODE, keySpec, ivspec); 
	
		return new String(cipher.get().doFinal(Base64.getDecoder().decode(value)), StandardCharsets.UTF_8); 
	
	}
	
}
