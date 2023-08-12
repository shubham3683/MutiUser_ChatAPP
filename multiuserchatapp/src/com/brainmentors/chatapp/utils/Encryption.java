package com.brainmentors.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
 public static String passwordEncrypt(String plainPassoword) throws NoSuchAlgorithmException {
	 String encryptedPassword=null;
	 MessageDigest messageDigest=MessageDigest.getInstance("MD5");
	 messageDigest.update(plainPassoword.getBytes());
	 byte[] encrypt= messageDigest.digest();
	StringBuffer sb= new StringBuffer();
	for(byte b: encrypt)
		sb.append(b);
	encryptedPassword=sb.toString();
	
	// System.out.println("encrypted password "+ encryptedPassword);
	 
	 
	 return encryptedPassword;
	 
 }
 
}