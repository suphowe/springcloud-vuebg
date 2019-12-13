package com.vuebg.admin.utils;

/**
 * 字符串工具类
 * @author suphowe
 * @date 2018-12-12
 */
public class StringUtils {

	/**
	 * 判空操作
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String value) {
		return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
	}

}
