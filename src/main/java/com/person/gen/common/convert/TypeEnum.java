package com.person.gen.common.convert;

import lombok.Getter;

/**
 * MySQL数据库字段类型
 *
 * @author xiaoming
 */
public enum TypeEnum {
	BIT("bit"),
	BOOLEAN("boolean"),
	TINYINT("tinyint"),
	SMALLINT("smallint"),
	INT("int"),
	BIGINT("bigint"),
	FLOAT("float"),
	DOUBLE("double"),
	DECIMAL("decimal"),
	VARCHAR("varchar"),
	CHAR("char"),
	TEXT("text"),
	DATETIME("datetime"),
	TIMESTAMP("timestamp"),
	BLOB("blob"),
	JSONB("jsonb");

	@Getter
	private final String type;

	TypeEnum(String type) {
		this.type = type;
	}

}
