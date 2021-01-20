package com.person.gen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * 登录日志实体类
 *
 * @author fu.yuanming
 * @since 2021-01-06
 */
@Data
@ApiModel("login_log")
public class LoginLog {

  @ApiModelProperty("登录日志 id")
  private Integer id;

  @ApiModelProperty("登录账号")
  private String loginName;

  @ApiModelProperty("登录ip")
  private String ip;

  @ApiModelProperty("登录状态（1：成功，0：失败）")
  private Integer loginStatus;

  @ApiModelProperty("登录时间")
  private Date loginTime;

  @ApiModelProperty("登录耗时（单位：ms）")
  private Long spendTime;

  @ApiModelProperty("浏览器名称")
  private String browserName;

  @ApiModelProperty("浏览器类型")
  private String browserType;

  @ApiModelProperty("browser_version")
  private String browserVersion;

  @ApiModelProperty("操作系统")
  private String operationSystem;

  @ApiModelProperty("备注")
  private String remark;

}
