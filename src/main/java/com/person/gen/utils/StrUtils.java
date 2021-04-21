package com.person.gen.utils;

/**
 * 字符串工具类
 *
 * @author fu.yuanming
 * @since 2021-01-25
 */
public class StrUtils {

	private static final String UNDERLINE = "_";

	/**
	 * 首字符大写
	 *
	 * @param originStr 待转换字符串
	 * @return 首字符大写字符串
	 */
	public static String toUpperCaseFirst(String originStr) {
		return originStr.charAt(0) >= 'A' && originStr.charAt(0) <= 'Z' ? originStr : originStr.substring(0, 1)
				.toUpperCase() + originStr.substring(1);
	}

	public static String toLowerCaseFirst(String originStr) {
		return originStr.charAt(0) >= 'a' && originStr.charAt(0) <= 'z' ? originStr : originStr.substring(0, 1)
				.toLowerCase() + originStr.substring(1);
	}

	/**
	 * 下划线命名字符串转换成class类名称
	 *
	 * @param originStr 下划线命名字符串
	 * @return class类名称
	 */
	public static String convertToClassName(String originStr) {
		if (originStr == null || originStr.isEmpty()) {
			return "";
		}
		if (!originStr.contains(UNDERLINE)) {
			return toUpperCaseFirst(originStr);
		}
		StringBuilder resultStr = new StringBuilder();
		String[] camels = originStr.split(UNDERLINE);
		for (String camel : camels) {
			if (camel.isEmpty()) {
				continue;
			}
			// 首字母大写
			resultStr.append(camel.substring(0, 1).toUpperCase());
			resultStr.append(camel.substring(1).toLowerCase());
		}
		return resultStr.toString();
	}

	/**
	 * 下划线命名字符串转换成驼峰命名字符串
	 *
	 * @param originStr 下划线命名字符串
	 * @return 驼峰命名字符串
	 */
	public static String convertToCamelCase(String originStr) {
		return StrUtils.toLowerCaseFirst(convertToClassName(originStr));
	}

}
