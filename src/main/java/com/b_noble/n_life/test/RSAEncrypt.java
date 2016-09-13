package com.b_noble.n_life.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

public class RSAEncrypt {
	/** */
	/**
	 * Main method for RSAEncrypt. @param args
	 */
	public static void main(String[] args) { 
	
		
		try { 
	RSAEncrypt encrypt = new RSAEncrypt(); 
	String encryptText = "encryptTex1t"; 
	KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA"); 
	keyPairGen.initialize(1024); 
	KeyPair keyPair = keyPairGen.generateKeyPair(); 
	RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); 
	RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); 
	byte[] e = encrypt.encrypt(publicKey, encryptText.getBytes()); 
	byte[] de = encrypt.decrypt(privateKey,e); 
	System.out.println(encrypt.bytesToString(e)); 
	System.out.println(encrypt.bytesToString(de)+"  ========================"); 
	} catch (Exception e) { 
		e.printStackTrace(); 
	} 
}

	protected String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += (char) bytes.intValue();
		}
		return result;
	}

	/** */
	/**
	 * Encrypt String. @return byte[]
	 */

	protected byte[] encrypt(RSAPublicKey publicKey, byte[] obj) {
		if (publicKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	protected byte[] decrypt(RSAPrivateKey privateKey, byte[] obj) { 
	if (privateKey != null) { 
		try { 
	Cipher cipher = Cipher.getInstance("RSA"); 
	cipher.init(Cipher.DECRYPT_MODE, privateKey); 
	return cipher.doFinal(obj); 
	} catch (Exception e) { 
	e.printStackTrace(); 
	} 
	} 
	return null; 
}
}
