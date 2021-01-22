package com.person.gen.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 字段信息类
 *
 * @author fu.yuanming
 * @since 2021-01-22
 */
@Data
public class ColumnInfo {

  @ApiModelProperty("字段名称")
  private String columnName;

  @ApiModelProperty("是否为 null（YES, NO）")
  private String isNullable;

  @ApiModelProperty("字段类型")
  private String dataType;

  @ApiModelProperty("字段注释")
  private String columnComment;

  @ApiModelProperty("主键字段")
  private String columnKey;

  @ApiModelProperty("主键信息")
  private String extra;

}
