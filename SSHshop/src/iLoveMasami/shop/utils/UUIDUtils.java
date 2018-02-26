package iLoveMasami.shop.utils;

import java.util.UUID;

/**
 * 生成随机字符串的工具类
 * @author iLoveMasami
 * @date   2018年1月24日 下午6:58:49
 */
public class UUIDUtils {
	/**
	 * 获得随机字符串
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
