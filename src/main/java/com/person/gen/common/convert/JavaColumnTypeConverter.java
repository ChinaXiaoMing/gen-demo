package com.person.gen.common.convert;

import java.util.HashMap;
import java.util.Map;

/**
 * Java数据类型转换器
 *
 * @author fu.yuanming
 * @since 2021-04-21
 */
public class JavaColumnTypeConverter {

	private static final Map<String, String> TYPE_MAP = new HashMap<>(64);
	private static final Map<String, String> TYPE_BOX_MAP = new HashMap<>(64);
	private static final String STRING = "String";
	private static final String INTEGER = "Integer";

	private JavaColumnTypeConverter() {

	}

	static {
		TYPE_MAP.put(TypeEnum.BIT.getType(), "boolean");
		TYPE_MAP.put(TypeEnum.BOOLEAN.getType(), "boolean");
		TYPE_MAP.put(TypeEnum.TINYINT.getType(), "int");
		TYPE_MAP.put(TypeEnum.SMALLINT.getType(), "int");
		TYPE_MAP.put(TypeEnum.INT.getType(), "int");
		TYPE_MAP.put(TypeEnum.BIGINT.getType(), "long");
		TYPE_MAP.put(TypeEnum.FLOAT.getType(), "float");
		TYPE_MAP.put(TypeEnum.DOUBLE.getType(), "double");
		TYPE_MAP.put(TypeEnum.DECIMAL.getType(), "BigDecimal");
		TYPE_MAP.put(TypeEnum.VARCHAR.getType(), STRING);
		TYPE_MAP.put(TypeEnum.CHAR.getType(), STRING);
		TYPE_MAP.put(TypeEnum.TEXT.getType(), STRING);
		TYPE_MAP.put(TypeEnum.DATETIME.getType(), "Date");
		TYPE_MAP.put(TypeEnum.TIMESTAMP.getType(), "Date");
		TYPE_MAP.put(TypeEnum.BLOB.getType(), "byte[]");
		TYPE_MAP.put(TypeEnum.JSONB.getType(), "Map<String, Object>");

		TYPE_BOX_MAP.put(TypeEnum.BIT.getType(), "Boolean");
		TYPE_BOX_MAP.put(TypeEnum.BOOLEAN.getType(), "Boolean");
		TYPE_BOX_MAP.put(TypeEnum.TINYINT.getType(), INTEGER);
		TYPE_BOX_MAP.put(TypeEnum.SMALLINT.getType(), INTEGER);
		TYPE_BOX_MAP.put(TypeEnum.INT.getType(), INTEGER);
		TYPE_BOX_MAP.put(TypeEnum.BIGINT.getType(), "Long");
		TYPE_BOX_MAP.put(TypeEnum.FLOAT.getType(), "Float");
		TYPE_BOX_MAP.put(TypeEnum.DOUBLE.getType(), "Double");
		TYPE_BOX_MAP.put(TypeEnum.DECIMAL.getType(), "BigDecimal");
		TYPE_BOX_MAP.put(TypeEnum.VARCHAR.getType(), STRING);
		TYPE_BOX_MAP.put(TypeEnum.CHAR.getType(), STRING);
		TYPE_BOX_MAP.put(TypeEnum.TEXT.getType(), STRING);
		TYPE_BOX_MAP.put(TypeEnum.DATETIME.getType(), "Date");
		TYPE_BOX_MAP.put(TypeEnum.TIMESTAMP.getType(), "Date");
		TYPE_BOX_MAP.put(TypeEnum.BLOB.getType(), "Byte[]");
		TYPE_BOX_MAP.put(TypeEnum.JSONB.getType(), "Map<String, Object>");
	}

	public static String convertJavaType(String type) {
		return TYPE_MAP.get(type);
	}

	public static String convertJavaBoxType(String type) {
		return TYPE_BOX_MAP.get(type);
	}

}
