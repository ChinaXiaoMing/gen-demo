package com.person.gen.dto;

import com.person.gen.entity.ColumnInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fu.yuanming
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ColumnInfoDTO extends ColumnInfo {

	@ApiModelProperty("实体类字段名称")
	private String columnModelName;

	@ApiModelProperty("Java类型")
	private String javaType;

}
