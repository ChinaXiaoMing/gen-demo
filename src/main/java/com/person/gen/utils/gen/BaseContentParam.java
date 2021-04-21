package com.person.gen.utils.gen;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Data;

/**
 * @author fu.yuanming
 * @since 2021-01-23
 */
@Data
public class BaseContentParam {

  @ApiModelProperty("包名称")
  private String packageName;
  @ApiModelProperty("功能描述")
  private String description;
  @ApiModelProperty("作者")
  private String author = "fu.yuanming";
  @ApiModelProperty("创建日期")
  private String fileCreateTime = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
  @ApiModelProperty("类名")
  private String className;

}
