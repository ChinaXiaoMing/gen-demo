package com.person.gen.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fu.yuanming
 * @since 2021-01-20
 */
@Data
public class TableInfo {

  @ApiModelProperty("表名称")
  private String tableName;

  @ApiModelProperty("表注释")
  private String tableComment;

}
