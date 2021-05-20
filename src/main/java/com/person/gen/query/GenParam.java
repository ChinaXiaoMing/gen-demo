package com.person.gen.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 生成代码前端配置参数
 *
 * @author fu.yuanming
 * @since 2021-04-21
 */
@Data
public class GenParam {

	@ApiModelProperty("功能描述")
	private String description;

	@ApiModelProperty(value = "表名称",required = true)
	private String tableName;

	@ApiModelProperty("包名称")
	private String packageName;

	@ApiModelProperty("生成作者")
	private String author;

	@ApiModelProperty("忽略前缀")
	private String ignorePrefix;

	@ApiModelProperty(value = "前端传递的表名称", hidden = true)
	private String originTableName;

	@ApiModelProperty("工程路径")
	private String projectPath;

	@ApiModelProperty(value = "Java目录", hidden = true)
	private String javaPath;

	@ApiModelProperty(value = "资源目录", hidden = true)
	private String sourcePath;

}
