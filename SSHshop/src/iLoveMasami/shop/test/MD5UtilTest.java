package iLoveMasami.shop.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import iLoveMasami.shop.utils.MD5Util;

public class MD5UtilTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String oldPassword = "12345678";
//		String newPassword = MD5Util.EncoderByMd5(oldPassword);
		String newPassword = MD5Util.MD5Encoder(oldPassword);
		System.out.println(newPassword);
		
//		System.out.println(MD5Util.checkpassword("6VEAgaww/6g/ELaM3hysBw==", oldPassword));
	}
	
}
