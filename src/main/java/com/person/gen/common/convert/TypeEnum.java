package com.person.gen.common.convert;

import lombok.Getter;

/**
 * MySQL数据库字段类型
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
	DATETIME("datetime"),
	BLOB("blob"),
	JSONB("jsonb");

	@Getter
	private final String type;

	TypeEnum(String type) {
		this.type = type;
	}

}
