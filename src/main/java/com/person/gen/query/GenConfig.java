package com.person.gen.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fu.yuanming
 * @since 2021-04-21
 */
@Data
public class GenConfig {

	@ApiModelProperty("功能描述")
	private String description;

	@ApiModelProperty("表名称")
	private String tableName;

	@ApiModelProperty("包名称")
	private String packageName;

}
