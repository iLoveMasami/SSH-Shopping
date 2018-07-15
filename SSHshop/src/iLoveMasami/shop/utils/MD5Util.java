package iLoveMasami.shop.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * MD5加密工具
 * 
 * @author iLoveMasami
 * @date 2018年7月15日 下午6:47:28
 */
public class MD5Util {
	public static String EncoderByMd5(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(s.getBytes("utf-8")));
		return newstr;
	}

	public static boolean checkpassword(String newpasswd, String oldpasswd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncoderByMd5(oldpasswd).equals(newpasswd))
			return true;
		else
			return false;
	}
}
