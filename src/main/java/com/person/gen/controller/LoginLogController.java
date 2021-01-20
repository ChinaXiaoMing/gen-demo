package com.person.gen.controller;

import com.github.pagehelper.PageInfo;
import com.person.gen.common.Result;
import com.person.gen.dto.LoginLogPageQuery;
import com.person.gen.entity.LoginLog;
import com.person.gen.service.ILoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录日志管理
 *
 * @author fu.yuanming
 * @since 2021-01-05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/loginLog")
@Api(tags = "登录日志管理API")
public class LoginLogController {

  private final ILoginLogService loginLogService;

  @ApiOperation("根据 ID 查询单条登录日志")
  @GetMapping("qryLoginLogById")
  public Result<LoginLog> qryLoginLogById(@RequestParam Integer id) {
    return Result.success(loginLogService.qryLoginLog(id));
  }

  @ApiOperation("查询登录日志列表（分页）")
  @PostMapping("qryLoginLogPage")
  public Result<PageInfo<LoginLog>> qryLoginLogPage(@RequestBody LoginLogPageQuery loginLogPageQuery) {
    return Result.success(loginLogService.qryLoginLogPage(loginLogPageQuery));
  }

  @ApiOperation("新增登录日志")
  @PostMapping("addLoginLog")
  public Result<Integer> addLoginLog(@RequestBody LoginLog loginLog) {
    return Result.success(loginLogService.addLoginLog(loginLog));
  }

  @ApiOperation("更新登录日志")
  @PostMapping("modLoginLog")
  public Result<Integer> modLoginLog(@RequestBody LoginLog loginLog) {
    return Result.success(loginLogService.modLoginLog(loginLog));
  }

  @ApiOperation("删除登录日志")
  @PostMapping("delLoginLog")
  public Result<Integer> delLoginLog(@RequestParam Integer id) {
    return Result.success(loginLogService.delLoginLog(id));
  }

}
