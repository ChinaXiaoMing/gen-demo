package com.person.gen.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类
 *
 * @author fu.yuanming
 * @since 2021-01-25
 */
public class DateUtils {

	private DateUtils() {

	}

	public static String formatDate(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ISO_DATE);
	}

}
